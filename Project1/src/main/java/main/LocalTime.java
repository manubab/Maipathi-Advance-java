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
 * Servlet implementation class LocalTime
 */
@WebServlet("/local")
public class LocalTime extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public LocalTime() {
        super();
       
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		LocalTime lt=new LocalTime();
		
		PrintWriter pw=response.getWriter();
		
		pw.println("<html> <body bg-colur=yellow text=red > <h1>");
		pw.println(lt);
		pw.println("</h1></body><html");
	}

}
