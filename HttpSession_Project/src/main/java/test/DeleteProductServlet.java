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
public class DeleteProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException                                                 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		HttpSession hs=req.getSession();
		
		if(hs==null)
		{
			pw.println("Session Expaired.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else
		{
			AdminBean ab=(AdminBean)hs.getAttribute("ab");
			pw.println("page belongs to "+ab.getfName()+"<br>");
			
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			if(al.size()==0)
			{
				pw.println("Products not Available");
				RequestDispatcher rd=req.getRequestDispatcher("link1.html");
				rd.include(req, res);
			}
			else
			{
			String pcode=req.getParameter("pcode");
				al.forEach((k)->{
					if(pcode.equals(k.getpCode()))
					{
						al.remove(pcode);
						int d=new DeleteProductDAO().delete(k);
						RequestDispatcher rd=req.getRequestDispatcher("link1.html");
						try {
							rd.include(req, res);
						} catch (ServletException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						if(d>0)
						{
							pw.println("Product delete Successfully.....<br>");
							
							
						}
					}
				});
			}
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			
			
		}
	}

}
