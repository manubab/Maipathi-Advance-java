package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteBooksServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			pw.println("Session Expaired....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else
		{
			AdminBean ab=(AdminBean)hs.getAttribute("ab");
			pw.println("page belongs to "+ab.getfName()+"<br>");
			
			ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("al");
			
			if(al.size()==0)
			{
				pw.println("Books are not Available");
				
			}
			
			else
			{
				String bcode=req.getParameter("bcode");
				al.forEach((k)->{
					if(bcode.equals(k.getbCode()))
					{
						al.remove(bcode);
						int d=new DeleteBooksDAO().delete(k);
						pw.println("Book deleted Successfully....<br>");
					}
				});
				RequestDispatcher rd=req.getRequestDispatcher("link1.html");
				rd.include(req, res);
			}
		}
	}
	

}
