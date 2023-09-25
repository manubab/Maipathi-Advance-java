package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
@WebServlet("/view")
public class ViewEmployeeServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		ArrayList<Employee> al=new ArrayList<>();
		
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req, res);
		
		if(al.size()==0)
		{
			pw.println("<br> Employee not Avilable....<br>");
			
		}else 
		{
			
			Iterator it=al.iterator();
				
				
				while(it.hasNext())
				{
					Employee e=(Employee)it.next();
					pw.println("<br> Emp id :"+e.getId());
					pw.println("<br> Emp Name :"+e.getName());
					pw.println("<br> Emp Desg:"+e.getDesg());
					pw.println("<br> Emp Sal:"+e.getSal());
				}
				
			
		}
	}

}
