package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("Session Expaired ......!<br>");
		}
		else
		{
			ServletContext sct=this.getServletContext();
		String fname=c[0].getValue();
			sct.removeAttribute("ub");
			c[0].setMaxAge(0);
			res.addCookie(c[0]);
			
			pw.println(fname+ "Customer Logout Successfully....!<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);

		}
		
	}

}
