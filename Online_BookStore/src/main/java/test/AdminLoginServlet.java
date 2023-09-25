package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		AdminBean ab=new AdminLoginDAO().login(req);
		
		if(ab==null)
		{
			pw.println("invalid login process.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}else
		{
			pw.println("Login Successfull.....!<br>"
					+ "Welcome to "+ab.getfName()+"<br>");
			
			HttpSession hs=req.getSession();
			hs.setAttribute("ab", ab);
			
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			
			
		}
	}

}
