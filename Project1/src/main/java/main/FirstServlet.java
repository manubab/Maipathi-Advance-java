package main;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/First")
public class FirstServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
		pw.println("Welcome to Servelt.....!");
		
	}

}
