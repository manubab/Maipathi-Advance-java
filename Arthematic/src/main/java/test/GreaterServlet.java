package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.http.*;
@WebServlet("/gvsv")
public class GreaterServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("html/text");
		
		int n1=Integer.parseInt(req.getParameter("v1"));
		int n2=Integer.parseInt(req.getParameter("v2"));
		
		if(n1>n2)
		{
			pw.println("<br> Greater Value :"+n1);
		}
		else
		{
			pw.println("<br> Smaller Value :"+n2);
		}
		
	}

}
