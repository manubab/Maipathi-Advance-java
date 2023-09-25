package text;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/dis")
public class Display extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ServletContext sct=req.getServletContext();
		
		String name=req.getParameter("uname");
		
		pw.println("Welcomt "+name);
		
		pw.println("============ Servlet Context ===========");
		
		pw.println("<br> Server :"+sct.getServerInfo());
		
		pw.println("contextvalue:"+sct.getInitParameter("x")+"<br>");
		pw.println("contextvalue:"+sct.getInitParameter("y")+"<br>");
		pw.println("contextvalue:"+sct.getInitParameter("z")+"<br>");
		
		Enumeration<String> e=sct.getInitParameterNames();
				
		 while(e.hasMoreElements())
		    {
		    	String str=e.nextElement();
		    	
		    	pw.println("<br>Context value "+str+sct.getInitParameter(str));
		    }


		
	}

}
