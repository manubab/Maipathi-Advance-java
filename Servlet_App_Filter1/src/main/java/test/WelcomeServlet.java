package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/log")
public class WelcomeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String fName = (String) req.getAttribute("fname");
		String lName = (String) req.getAttribute("lname");
		String addr = (String) req.getAttribute("addr");
		String mId = (String) req.getAttribute("mid");
		String phNo = (String) req.getAttribute("phno");
		pw.println("Welcome User :" + fName + "<br>");
		pw.println(fName + "&nbsp&nbsp&nbsp" + lName + "&nbsp&nbsp&nbsp" + addr + "&nbsp&nbsp&nbsp" + mId
				+ "&nbsp&nbsp&nbsp" + phNo + "<br>");

		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req, res);

	}
}
