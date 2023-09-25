package test;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/ad")
public class AddServlet extends GenericServlet
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		int n1=Integer.parseInt(req.getParameter("v1"));
		int n2=Integer.parseInt(req.getParameter("v2"));
		
		int n3=n1+n2;
		
		pw.println("Sum :"+n3+" <br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
		
	}
	
	
		
	
	

}
