package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException                                 
	{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			pw.println("Session Expaired.....<br>");
		}
		else
		{
			hs.removeAttribute("ab");
			hs.invalidate();
			pw.println("logged out Seccessfully....<br>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.include(req, res);
		
	}

}
