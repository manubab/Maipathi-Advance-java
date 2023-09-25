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
 * Servlet implementation class CounterServlet
 */
@WebServlet("/count")
public class CounterServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
	int count=0;
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolur=green text=white><h1>");
		count++;
		pw.println("This page has been accesed "+ count+" times");
		pw.println("</h1></body></html> ");
	}

}
