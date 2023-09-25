package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/first")
public class FirstServlet implements Servlet
{
	public void init(ServletConfig sc)
	{
		// no body
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		String uName=req.getParameter("uName");
		String mid=req.getParameter("mid");
		
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		pw.println("***** UserDetails *****");
		pw.println("<br>UserName :"+uName);
		pw.println("<br>MaildId :"+mid);
	}
	
	public void destroy()
	{
		//no body
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
