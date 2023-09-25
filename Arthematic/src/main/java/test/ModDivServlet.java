package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/md")
public class ModDivServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
	int n1=Integer.parseInt(req.getParameter("v1"));
	int n2=Integer.parseInt(req.getParameter("v2"));
	
	int n=n1%n2;
	
	PrintWriter pw=res.getWriter();
	
	pw.println("Modulo-Division :"+n+"<br>");
	
	RequestDispatcher rd=req.getRequestDispatcher("input.html");
	rd.include(req, res);
		
		
	}
	

}
