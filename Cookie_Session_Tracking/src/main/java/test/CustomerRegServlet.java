package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/reg")
public class CustomerRegServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException                                    
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		CustomerBean cb=new CustomerBean();
		
		cb.setCname(req.getParameter("cName"));
		cb.setMid(req.getParameter("mid"));
		cb.setPhno(Long.parseLong(req.getParameter("phno")));
		cb.setCity(req.getParameter("city"));
		cb.setState(req.getParameter("state"));
		cb.setPincode(Integer.parseInt(req.getParameter("pincode")));
		
	     int k=new RegisterDAO().register(cb);
	     
	     if(k>0)
	     {
	    	 pw.println("Customer register Successfully.....<br>");
	    	 RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
	    	 rd.include(req, res);
	     }
	}
}
