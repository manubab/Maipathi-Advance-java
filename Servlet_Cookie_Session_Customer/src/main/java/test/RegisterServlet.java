package test;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		CustBean cb=new CustBean();
		
		cb.setuName(req.getParameter("uname"));
		cb.setpWord(req.getParameter("pword"));
		cb.setfName(req.getParameter("fname"));
		cb.setlName(req.getParameter("lname"));
		cb.setAddr(req.getParameter("addr"));
		cb.setmId(req.getParameter("mid"));
		cb.setPhNo(Long.parseLong(req.getParameter("phno")));
		
		int k=new RegisterDAO().register(cb);
		if(k>0)
		{
			pw.println("Custmer Register Successfully.....!"+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		
	}

}
