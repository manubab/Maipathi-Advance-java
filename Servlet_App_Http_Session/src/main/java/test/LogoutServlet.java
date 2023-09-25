package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException        
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		Cookie []c=req.getCookies();
		
		if(c==null)
		{
			pw.println("Session expaired ....<br>");
			
		}else
		{
			ServletContext sct=this.getServletContext();
			sct.removeAttribute("ub");
			c[0].setMaxAge(0);
			res.addCookie(c[0]);
			pw.println("User Logged Our Successfully");
			
			
		}
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, res);
	}
}
