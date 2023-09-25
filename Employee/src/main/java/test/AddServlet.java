package test;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;
@WebServlet("/add")
public class AddServlet extends GenericServlet
{
	public EmployeeBean eb=null;
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		eb=new EmployeeBean();
		
		eb.setId(req.getParameter("id"));
		eb.setName(req.getParameter("name"));
		eb.setDesg(req.getParameter("desg"));
		int bSal=Integer.parseInt(req.getParameter("bsal"));
		eb.setbSal(bSal);
		float totSal=bSal+(0.93f*bSal)+(0.63f*bSal);
		eb.setTotSal(totSal);
		
		int k=new InsertEmployeeDAO().insert(eb);
		
		if(k>0)
		{
			pw.println("Employee Details Added Succefully");
			RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			rd.include(req, res);
		}
		
	}

}
