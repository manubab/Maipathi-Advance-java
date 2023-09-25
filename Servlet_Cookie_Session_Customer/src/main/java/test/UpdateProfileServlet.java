package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		Cookie[] c=req.getCookies();
		if(c==null)
		{
			pw.println("Session Expaired......<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
			
		}
		else
		{
			String fName=c[0].getValue();
			ServletContext sct=this.getServletContext();
			CustBean cb=(CustBean)sct.getAttribute("cb");
			
			cb.setAddr(req.getParameter("addr"));
			cb.setmId(req.getParameter("mid"));
			cb.setPhNo(Long.parseLong(req.getParameter("phno")));
			
			int k=new UpdateProfileDAO().update(cb);
			if(k>0)
			{
			    pw.println(fName+" Customer profile updateted Successfully.....<br>");
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
			}
			
			
					
		}
	}

}
