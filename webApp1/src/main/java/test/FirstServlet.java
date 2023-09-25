package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/first")
public class FirstServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String uName=req.getParameter("uname");
		String mId=req.getParameter("mid");
		
		res.sendRedirect
		("http://localhost:8081/WebApp2/second?mid="+mId);
	}

}
