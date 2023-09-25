package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/choice")
public class ChoiceServlet implements Servlet 
{
	public void init(ServletConfig sc) throws ServletException
	{
		// no body
	}
	
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		String s1=req.getParameter("s1");
		if(s1.equals("Add"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("sd");
			rd.forward(req, res);
		}
		
	}
	
	public void destroy()
	{
		// no code
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
