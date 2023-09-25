package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		HttpSession hs = req.getSession(false);
		if (hs == null) {
			pw.println("Session Expaired.....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("home.html");
			rd.include(req, res);
		} else {
			String pcode = req.getParameter("pcode");
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) hs.getAttribute("al");

			al.forEach((k) -> {
				if (pcode.equals(k.getpCode())) {
					pw.println("<form action='update' method='POST'>");
					pw.println("<input type='hidden' name='pcode' value='" + k.getpCode() + "'>");
					pw.println("ProdPrice:<input type='text' name='pprice' value='" + k.getpPrice() + "'<br>");
					pw.println("proQty :<input type='text' name='pqty' value='" + k.getpQty() + "'"+"<br>");
					pw.println("<input type='submit' value='UpdateProduct'>");
					pw.println("</form>");
				}
			});
		}
	}

}
