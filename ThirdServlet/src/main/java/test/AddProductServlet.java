package test;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ProductBean pb = new ProductBean();
		pb.setpCode(req.getParameter("pCode"));
		pb.setpName(req.getParameter("pName"));
		String price = req.getParameter("pPrice");
		pb.setpPrice(Float.parseFloat(price));
		String s = req.getParameter("pQty");
		pb.setpQty((Integer.parseInt(s)));

		int k = new InsertProductDAO().insert(pb);

		if (k > 0) {
			pw.println("Product Added Succesfully.....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}

	}

}
