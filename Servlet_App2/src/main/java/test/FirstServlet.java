package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/req")
public class FirstServlet implements Servlet
{
	public void init(ServletConfig sc) throws ServletException
	{
		// no code
		
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		String pprice=req.getParameter("pprice");
		String pqty=req.getParameter("pqty");
		
		pw.println("<br> PRODUCT DETAILS br> ");
		
		pw.println("<br>  Product Code :"+pcode);
		pw.println("<br>  Product Name :"+pname);
		pw.println("<br>  Product Price :"+pprice);
		pw.println("<br>  Product Pqty :"+pqty);

		
		
	}
	public void destroy()
	{
		// no code
	}
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}
	public String getServletInfo()
	{
		return "FirstServlet";
	}

}
