package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class TableServlet
 */
@WebServlet("/table")
public class TableServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public TableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
		pw.println("<html> <body bgcolour=cyen text=blue");
		pw.println("<table border=20>");
		
		for(int i=1;i<=100;i++)
		{
			pw.println("<td> 5 </td>");
			pw.println("<td> x </td>" );
			pw.println("<td>"+i+"</td>");
			pw.println("<td> = </td>");
			pw.println("<td>"+5*i+"</td>");
		}
		pw.println("</table></body></html>");
		
	}
	

}
