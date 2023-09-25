package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/first")
public class FirstServlet implements Servlet
{
	public void init(ServletConfig sc)throws ServletException
	{
		// no code
	}
	
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String bcode=req.getParameter("bcode");
		String bname=req.getParameter("bname");
		String bauthor=req.getParameter("bauthor");
		String bprice=req.getParameter("bprice");
		String bqty=req.getParameter("bqty");
		
		pw.println("...... <br> BOOK DETAILS ......");
		
		pw.println("<br> BOOK CODE :"+bcode);
		pw.println("<br> BOOK NAME :"+bname);
		pw.println("<br> BOOK AUTHOR :"+bauthor);
		pw.println("<br> BOOK PRICE :"+bprice);
		pw.println("<br> BOOK QTY :"+bqty);
		
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
