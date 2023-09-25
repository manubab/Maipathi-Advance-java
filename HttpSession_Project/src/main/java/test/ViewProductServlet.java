package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

@WebServlet("/view")
public class ViewProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			pw.println("Session Expaired.....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("home.html");
			rd.include(req, res);
		} else {
			AdminBean ab = (AdminBean) hs.getAttribute("ab");
			pw.println("page belongs to " + ab.getfName() + "<br>");

			ArrayList<ProductBean> al = new ViewProductDAO().viewAll();
			hs.setAttribute("al", al);

			if (al.size() == 0) {
				pw.println("Products Not available...<br>");
			} else {
				al.forEach((k) -> {
					ProductBean pb = (ProductBean) k;

					pw.println(pb.getpCode() + "&nbsp&nbsp" + pb.getpName() + "&nbsp&nbsp" + pb.getpPrice()
							+ "&nbsp&nbsp" + pb.getpQty() + "&nbsp&nbsp" + "<a href='edit?pcode=" + pb.getpCode()
							+ "'>Edit</a>" + "&nbsp&nbsp" + "<a href='delete?pcode=" + pb.getpCode()
							+ "'>Delete</a><br>");

				});

				pw.println("<a href='link1.html'>Back</a>" + "&nbsp&nbsp" + "<a href='logout'>Logout</a>");
			}
		}
	}

}
