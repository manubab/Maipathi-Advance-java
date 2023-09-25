package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException                                            
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		Cookie[] c=req.getCookies();
		
		if(c==null)
		{
			pw.println("Session Expaired .....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
			
		}
		else
		{
			String fName=c[0].getValue();
			ServletContext sct=this.getServletContext();
			UserBean ub=(UserBean)sct.getAttribute("ub");
			
			ub.setAddr(req.getParameter("addr"));
			ub.setmId(req.getParameter("mid"));
			ub.setPhNo(Long.parseLong(req.getParameter("phno")));
			
			int k=new UpdateProfileDAO().update(ub);
			pw.println("page belongs to User :"+fName);
			if(k>0)
			{
			
				pw.println("Profile Updated Successfully....!");
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
				
				
			}
			
		}
		
		
	}

}
