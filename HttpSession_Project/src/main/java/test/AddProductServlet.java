package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/add")
public class AddProductServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			pw.println("Session Expaired....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
			
		}
		else
		{
			AdminBean ab=(AdminBean)hs.getAttribute("ab");
			ProductBean pb=new ProductBean();
			
			pb.setpCode(req.getParameter("pcode"));
			pb.setpName(req.getParameter("pname"));
			pb.setpPrice(Float.parseFloat(req.getParameter("pprice")));
			pb.setpQty(Integer.parseInt(req.getParameter("pqty")));
			
			int k=new AddProductDAO().add(pb);
			pw.println("Page belongs to "+ab.getfName()+"<br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			
			if(k>0)
			{
				pw.println("<br> product Added Successfullyy...<br>");
			}
			
		}
			
	}

}
