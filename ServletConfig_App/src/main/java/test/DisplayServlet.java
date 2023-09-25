package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;

public class DisplayServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String uName=req.getParameter("uname");
		pw.println("Welcome :"+uName);
		
		ServletConfig scf=this.getServletConfig();
		pw.println("<br> ===========ServletConfig=========");
		
		pw.println("<br> "+scf.getServletName());
		
		Enumeration<String> e=scf.getInitParameterNames();
		
		while(e.hasMoreElements())
		{
			String str=e.nextElement();
			
			pw.println("<br> Config values : "+scf.getInitParameter(str));
		}
		
	}

}
