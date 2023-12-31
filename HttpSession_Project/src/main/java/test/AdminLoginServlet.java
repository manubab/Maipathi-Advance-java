package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		AdminBean ab=new AdminLoginDAO().login(req);
		
		if(ab==null)
		{
			pw.println("invalid login process.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else 
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("ab", ab);
			pw.println("Welcome Admin :"+ab.getfName()+"<br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
		}
		
		
		
		
	}

}
