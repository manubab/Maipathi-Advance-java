package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		Cookie c[]=request.getCookies();
		if(c==null)
		{
			pw.println("Session exparied....!<br>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);

			
			
		}else
		{
			String fName=c[0].getValue();
			
			pw.println("Page belongs to Customer :"+fName);
			
			ServletContext sct=this.getServletContext();
			
			CustBean cb=(CustBean)sct.getAttribute("cb");
			
			pw.println(cb.getuName()+"&nbsp&nbsp"
					+cb.getpWord()+"&nbsp&nbsp"
					+cb.getfName()+"&nbsp&nbsp"
					+cb.getlName()+"&nbsp&nbsp"
					+cb.getAddr()+"&nbsp&nbsp"
					+cb.getmId()+"&nbsp&nbsp"
					+cb.getPhNo()+"&nbsp&nbsp"
					+"<a href='edit'>EditProfile</a>"
					+"&nbsp&nbsp"
					+"<a href='update'>UpdateProfile</a>");
			
			
		}
		
				
	}

}
