package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/add")
public class AddEmpServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Employee e=new Employee();
		
		e.setId(req.getParameter("id"));
		e.setName(req.getParameter("name"));
		e.setDesg(req.getParameter("desg"));
		e.setSal(req.getParameter("sal"));
		
		int k=new InsertEmployeeDetailsDAO().Insert(e);
		
		if(k>0)
		{
			pw.println("<br> Product Added Succesfully.....! <br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("EmployeeDetails.html");
			rd.forward(req, res);
		}
		
		
	}

}
