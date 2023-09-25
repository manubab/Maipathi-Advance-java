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
@WebServlet("/view")
public class ViewAllBooks extends HttpServlet
{
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res)throws IOException,ServletException     
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			pw.println("Session expaired.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else
		{
			AdminBean ab=(AdminBean)hs.getAttribute("ab");
			pw.println("page Belongs to "+ab.getfName()+"<br>");
			ArrayList<BookBean> al=new ViewAllBooksDAO().viewBooks();
			
			hs.setAttribute("al", al);
			
			if(al.size()==0)
			{
				pw.println("Books Not Available....<br>");
			}
			else
			{
				al.forEach((k)->{
					pw.println(k.getbCode()+"&nbsp&nbsp"
							+k.getbName()+"&nbsp&nbsp"
							+k.getbAuthor()+"&nbsp&nbsp"
							+k.getbPrice()+"&nbsp&nbsp"+
							+k.getbQty()+"&nbsp&nbsp"
							
	+"<a href='edit?bcode="+k.getbCode()+"'>Edit</a>"
	+"&nbsp&nbsp"
	+"<a href='delete?bcode="+k.getbCode()+"'>Delete</a><br>");
					
				});
				
				pw.println("<a href='link1.html'>Back</a>"
						+"&nbsp&nbsp"
						+"<a href='logout'>Logout</a>");
				
			}
		}
		
		
	}

}
