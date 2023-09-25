package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/add")
public class AddServlet extends GenericServlet
{
	BookBean bb=null;
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		bb=new BookBean();
		bb.setbCode(req.getParameter("bcode"));
		bb.setbName(req.getParameter("bname"));
		bb.setbAuthor(req.getParameter("bauthor"));
		bb.setbPrice(Float.parseFloat(req.getParameter("bprice")));
		bb.setbQty(Integer.parseInt(req.getParameter("bqty")));
		
		int k=new InsertBookDAO().insert(bb);
		
		if(k>0)
		{
			pw.println("Book Successfully added.....!");
			RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			rd.include(req, res);
		}
		
		
	}

}
