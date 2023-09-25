package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.*;
@WebServlet("/view")
public class ViewServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ArrayList<BookBean> al=new ViewBooksDAO().retrive();
		
		if(al.size()==0)
		{
			pw.println("Books or not Avilable......!");
			RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			rd.include(req, res);
			
		}else
		{
			al.forEach((k)->
			{
				BookBean bb=(BookBean)k;
				pw.println(bb.getbCode()+"&nbsp&nbsp"+bb.getbName()+"&nbsp&nbsp"+bb.getbAuthor()+"&nbsp&nbsp");
				pw.println(bb.getbPrice()+"&nbsp&nbsp"+bb.getbQty()+"<br>");
				
			});
		}
	}
	

}
