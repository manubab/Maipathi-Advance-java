package text;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/add")
public class AddServlet extends GenericServlet
{
	ProductBean pb=null;
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pb=new ProductBean();
		pb.setpCode(req.getParameter("code"));
		pb.setpName(req.getParameter("name"));
		pb.setpPrice(Float.parseFloat(req.getParameter("price")));
		pb.setpQty(Integer.parseInt(req.getParameter("qty")));

		int k=new InsertProductDAO().insert(pb);
		
		if(k>0)
		{
			pw.println("Product Added Succesfully....!");
			RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			rd.include(req, res);
		}
	}

}
