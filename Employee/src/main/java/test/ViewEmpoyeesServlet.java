package test;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/view")
public class ViewEmpoyeesServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ArrayList<EmployeeBean> al=new ViewEmployeeDAO().retrive();
		
		if(al.size()==0)
		{
			pw.println("No EMployee details");
		}else
		{
			al.forEach((k)->{
				EmployeeBean eb=(EmployeeBean)k;
				pw.println(eb.getId()+"&nbsp&nbsp");
				pw.println(eb.getName()+"&nbsp&nbsp");
				pw.println(eb.getDesg()+"&nbsp&nbsp");
				pw.println(eb.getbSal()+"&nbsp&nbsp");
				pw.println(eb.getTotSal()+
						"<a href='edit'>EDIT</a><a href='delete'>DELETE</a><br>");




				
			});
		}
		
		
		
	}

}
