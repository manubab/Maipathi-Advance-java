package test;

import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/first")
public class FirstServlet implements Servlet {
	public void init(ServletConfig sc) {
		// noCode
	}

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		String name = req.getParameter("uname");
		String mid = req.getParameter("mid");

		pw.println("=======Display User Details ======");
		pw.println("<br> UserName :" + name);
		pw.println("<br> MailID :" + mid);

	}

	public void destroy() {

	}

	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}

	public String getServletInfo() {
		return "FirstServlet";
	}

}
