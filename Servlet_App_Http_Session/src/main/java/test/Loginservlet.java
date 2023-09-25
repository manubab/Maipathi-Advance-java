package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/log")
public class Loginservlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		UserBean ub=new LoginDAO().login(req);
		
		if(ub==null)
		{
			pw.println("invalid login process ...!");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			ServletContext sct=this.getServletContext();
			sct.setAttribute("ub", ub);
			
			Cookie c=new Cookie("fName",ub.getfName());
			
			res.addCookie(c);
			
			pw.println("Welcome User :"+ub.getfName()+"<br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
             rd.include(req, res);
			
		}
		
		
	}
	
	

}
