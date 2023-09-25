package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends GenericServlet
{
	EmployeeBean eb=null;
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
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
		pw.println("Employee Details Added Succedfully.....!");
		
		RequestDispatcher rs=req.getRequestDispatcher("choice.html");
		rs.include(req, res);
		
		}
		
	}
	

}
