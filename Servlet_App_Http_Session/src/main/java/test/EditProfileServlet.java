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
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet         
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException                                                             
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		Cookie[] c=req.getCookies();
		
		if(c==null)
		{
			pw.println("Session Expaired.....!<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else
		{
			ServletContext scf=this.getServletContext();
			UserBean ub=(UserBean)scf.getAttribute("ub");
			pw.println("<form action='update' method='post'>");
			pw.println("Address :<input type='text' name='addr' value='"+ub.getAddr()+"'><br>");
			pw.println("MailId:<input type='text' name='mid' value='"+ub.getmId()+"'<br>");
			pw.println("PhnoNo:<input type='text' name='phno' value='"+ub.getPhNo()+"'<br>");
			pw.println("<input type='submit' value='Update'>");
			pw.println("</form");
		}
		
		
	}
	

}
