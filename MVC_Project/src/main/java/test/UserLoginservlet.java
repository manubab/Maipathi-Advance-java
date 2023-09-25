package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/log")
public class UserLoginservlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException  
	{
		UserBean ub=new UserLoginDAO().login(req);
		
		if(ub==null)
		{
			req.setAttribute("msg", "Invalid login Process....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Exit.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("ubean", ub);
			
			RequestDispatcher rd=req.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(req, res);
			

		}
		
	}
	

}
