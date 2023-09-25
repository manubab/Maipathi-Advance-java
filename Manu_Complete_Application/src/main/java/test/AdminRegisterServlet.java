package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminRegister")
public class AdminRegisterServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		Admin ab=new Admin();
		
		ab.setAdminFirstName(req.getParameter("adminFirstName"));
		ab.setAdminLastName(req.getParameter("adminLastName"));
		ab.setAdminMail(req.getParameter("adminMail"));
		ab.setPassword(req.getParameter("password"));
		ab.setContact(Integer.parseInt(req.getParameter("contact")));
		int k=new AdminRegisterDAO().register(ab);
		
		if(k>0)
		{
			pw.println("Admin Register Successfully....!");
			
			RequestDispatcher rd=req.getRequestDispatcher("AdminRegister.html");
			rd.include(req, res);
			
		}
	}

}
