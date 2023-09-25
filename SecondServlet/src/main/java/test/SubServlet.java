package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/sd")
public class SubServlet implements Servlet
{
	public void init(ServletConfig sc) throws ServletException
	{
		// no code;
	}
	
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		int a=Integer.parseInt(req.getParameter("V1"));
		int b=Integer.parseInt(req.getParameter("V2"));
		
		int c=a-b;
		
		pw.println("Sub :"+c+"<br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
		
	}
	public void destroy()
	{
		
	}
	
	public String getServletInfo()
	{
		return "FirstServlet";
	}
	
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}

}
