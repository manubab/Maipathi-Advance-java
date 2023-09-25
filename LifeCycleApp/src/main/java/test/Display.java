package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/dis")
public class Display extends HttpServlet
{
	public int x;
	public int y;
	
    public Display()
    {
    	x++;
    	y++;
    }
    public void init()throws ServletException
    {
    	x++;
    	y++;
    }
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException                                 
    {
    	res.setContentType("text/html");
    	PrintWriter pw=res.getWriter();
    	String uName=req.getParameter("uname");
    	pw.println("Welcome :"+uName+"<br>");
    	pw.println("Value of x "+x +"<br>");
    	pw.println("Value of y "+y );
    	
    	
    }
    
    public void destroy()
    {
    	x=200;
    	y=300;
    }

}
