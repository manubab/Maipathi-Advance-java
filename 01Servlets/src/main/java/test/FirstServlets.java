package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/first")
public class FirstServlets implements Servlet {

	

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.getServletInfo();
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
		PrintWriter pw=arg1.getWriter();
		arg1.setContentType("text/html");
		
		String name=arg0.getParameter("uname");
		String mail=arg0.getParameter("mid");
		
		pw.println("****** Display from Servlet *******");
		pw.println("<br> UserName :"+name);

		pw.println("<br> Mail Id :"+mail);
		
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
