package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/add")
public class AddBookServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			pw.print("Session Expaired.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
			
		}
		else
		{
			AdminBean ab=(AdminBean)hs.getAttribute("ab");
			pw.println("Page belongs to "+ab.getfName()+"<br>");
		
			BookBean bb=new BookBean();
			
			bb.setbCode(req.getParameter("bcode"));
			bb.setbName(req.getParameter("bname"));
			bb.setbAuthor(req.getParameter("bauthor"));
			bb.setbPrice(Float.parseFloat(req.getParameter("bprice")));
			bb.setbQty(Integer.parseInt(req.getParameter("bqty")));
			
			int k=new AddBookDAO().add(bb);
			
			pw.print("page belongs to "+ab.getfName()+"<br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			
			if(k>0) {
				pw.println("Books Addedd Successfully....<br>");
			}
			
			
			
		}
		
	}
	

}
