package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/edit")
public class EditServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		Cookie []c=req.getCookies();
		
		if(c==null)
		{
			pw.println("Session Expaired ....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else
		{
			ServletContext sct=this.getServletContext();
			CustBean cb=(CustBean)sct.getAttribute("cb");
			
			pw.println("<form action='update' method='post'>");
			pw.println("CustomerAddress:<input type='text' name='addr' value='"+cb.getAddr()+"'>");
			pw.println("CustomerMailId :<input type='text' name='mid' value='"+cb.getmId()+"'>" );
			pw.println("PhnoneNO: <input type='text' name='phno' value='"+cb.getPhNo()+"'>");
			pw.println("<input type='submit' value='UpdateProfile'>");
			pw.println("</form>");
			
		}
		
	}

}
