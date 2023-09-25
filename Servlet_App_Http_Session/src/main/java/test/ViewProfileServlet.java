package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res )throws IOException,ServletException                                                
	{
         PrintWriter pw= res.getWriter();
         res.setContentType("text/html");
         Cookie[] c=req.getCookies();
         
         if(c==null)
         {
        	 pw.println("Session expaired.....!");
        	 RequestDispatcher rd=req.getRequestDispatcher("login.html");
        	 rd.include(req, res);
         }
         else
         {
        	 String fName=c[0].getValue();
        	 pw.println("Page belongs to User :"+fName+"<br>");
        	 ServletContext sct=this.getServletContext();
        	 
        	 UserBean ub=(UserBean)sct.getAttribute("ub");
        	 
        	 pw.println(ub.getuName()+"&nbsp&nbsp"
        			 +ub.getpWord()+"&nbsp&nbsp"
        			 +ub.getfName()+"&nbsp&nbsp"
        			 +ub.getlName()+"&nbsp&nbsp"
        			 +ub.getAddr()+"&nbsp&nbsp"
        			 +ub.getmId()+"&nbsp&nbsp"
        			 +ub.getPhNo()+"&nbsp&nbsp"
        			 +"<a href='edit'>EditProfile</a>"
        			 +"&nbsp&nbsp"
        			 +"<a href='logout'>Logout</a>");
         }
         
	}

}
