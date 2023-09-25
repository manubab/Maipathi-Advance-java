package test;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/add")
public class StudentAddDAO extends GenericServlet 
{
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("StudentName  :"+req.getParameter("name"));
		pw.println("StudentMarks :"+req.getParameter("marks"));
		pw.println("StudentPercentage :"+req.getParameter("percentage"));
		
		
	}
}
