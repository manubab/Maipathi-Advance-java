package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/sb")
public class SubServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		
		int n1=Integer.parseInt(req.getParameter("v1"));	
		int n2=Integer.parseInt(req.getParameter("v2"));
		
		int n=n1-n2;
		
		pw.println("Sum :"+n+"<br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}

}
