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
@WebServlet("/edit")
public class EditBooksServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			pw.println("Session Expaired.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
			
		}
		else 
		{
			String bcode=req.getParameter("bcode");
			
			ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("al");                         
			
			al.forEach((k)->{
				
				if(k.getbCode().equals(bcode))
				{
					pw.println("<form action='update' method='POST'>");
					pw.println("<input type='hidden' name='bcode' value='"+bcode+"'>" );
					pw.println("BookPrice :<input type='text' name='bprice' value='"+k.getbPrice()+"'>");
					pw.println("BookQty:<input type='text' name='bqty' value='"+k.getbQty()+"'>");
					pw.println("<input type='submit' value='updateBook'>");
					pw.println("</form>");
					
					
				}
			});
		}
		
		
	}
	

}
