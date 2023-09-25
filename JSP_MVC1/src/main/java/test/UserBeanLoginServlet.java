package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/user")
public class UserBeanLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		UserBean ub=new UserLoginDAO().login(req);
		
		if(ub==null)
		{
			req.setAttribute("msg", "invalid login process.....<br>");
			req.getRequestDispatcher("Response.jsp").forward(req, res);
			
		}
		else
		{
			HttpSession hs=req.getSession();
			
			hs.setAttribute("ub", ub);
			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
			
		}
		
	}

}
