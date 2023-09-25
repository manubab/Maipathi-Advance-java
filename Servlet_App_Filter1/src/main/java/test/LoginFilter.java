package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/log")
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		UserBean ub = new LoginDAO().login(req);
		if (ub == null) {
			pw.println("invalid login process.....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		} else {
			req.setAttribute("fname", ub.getfName());
			req.setAttribute("lname", ub.getlName());
			req.setAttribute("addr", ub.getAddr());
			req.setAttribute("mid", ub.getmId());
			req.setAttribute("phno", String.valueOf(ub.getPhNo()));
			chain.doFilter(req, res);
		}

	}

}
