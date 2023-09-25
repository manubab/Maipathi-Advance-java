package text;
import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.annotation.*;
@WebServlet("/view")
public class ViewServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ArrayList<ProductBean> al=new ViewProductDAO().retrive();
		
		if(al.size()==0)
		{
			pw.println("Products Not Available........!");
			
		}
		else
		{
			al.forEach((k)->{
				ProductBean pb=(ProductBean)k;
				pw.println(pb.getpCode()+"&nbsp&nbsp");
				pw.println(pb.getpName()+"&nbsp&nbsp");
				pw.println(pb.getpPrice()+"&nbsp&nbsp");
				pw.println(pb.getpQty()+"<br>");


			});
		}
		
	}

}
