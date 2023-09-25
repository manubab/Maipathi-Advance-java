package test;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet
{
	
	
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException                                                          
	{
		String s1=req.getParameter("s1");
		if(s1.equals("Add"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			rd.forward(req, res);
			
		}else if(s1.equals("Sub"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("sb");
			rd.forward(req, res);
			
		}else if(s1.equals("Mul"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("mul");
			rd.forward(req, res);
			
		}
		else if(s1.equals("Div"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("div");
			rd.forward(req, res);
		}else if(s1.equals("Mod div"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("md"); 
			rd.forward(req, res);
			
		}else if(s1.equals("Gre"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("gvsv"); 
			rd.forward(req, res);

		}else
		{

			PrintWriter pw=res.getWriter();
			pw.println("invalid choice ur taken....!");

		}
		
	}
	
	

}
