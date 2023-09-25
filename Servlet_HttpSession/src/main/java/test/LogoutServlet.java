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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			pw.println("Session expaired.......<br>");
			
		}
		else 
		{
			hs.removeAttribute("ab");
			hs.invalidate();
			pw.println("logged out Succefully.....<br>");
			
		}
		RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.include(req, res);

		
	}

}
