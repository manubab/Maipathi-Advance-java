package test;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/log")
public class UserLoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)   throws IOException,ServletException                                                        
	{
		UserBean ub=new UserLoginDAO().login(req);
		
		if(ub==null)
		{
			req.setAttribute("msg", "invalid Login Details......<br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("Exit.jsp");
			rd.include(req, res);
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
