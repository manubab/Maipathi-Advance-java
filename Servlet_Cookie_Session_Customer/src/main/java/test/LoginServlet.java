package test;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.http.*;
@WebServlet("/log")
public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		CustBean cb=new LoginDAO().login(req);
		
		if(cb==null)
		{
			pw.println("Invalid login process.....!");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			ServletContext sct=this.getServletContext();
			sct.setAttribute("cb", cb);
			
			Cookie c=new Cookie("fname",cb.getfName());
			res.addCookie(c);
			pw.println("Welcome to Customer :"+cb.getfName());
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);

		}
		
	}

}
