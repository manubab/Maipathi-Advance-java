package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ArrayList<ProductBean> al=new RetriveProductDAO().retrive();
		
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req, res);
		
		if(al.size()==0)
		{
			pw.println("<br> Products not Avilable ....!");
		}
		else
		{
			Iterator<ProductBean> it=al.iterator();
			
			while(it.hasNext())
			{
				ProductBean pb=(ProductBean)it.next();
				pw.println("<br> :"+pb.getpCode()+"<br> :"+pb.getpName()+"<br> :"+pb.getpPrice()+"<br> :"+pb.getpQty());
			}
		}
	}
	

}
