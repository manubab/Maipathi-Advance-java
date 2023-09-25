package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		HttpSession hs = req.getSession();

		if (hs == null) {
			pw.println("Session Expaired....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("home.html");
			rd.include(req, res);

		} else {
			AdminBean ab = (AdminBean) hs.getAttribute("ab");
			pw.println("Page belongs to " + ab.getfName() + "<br>");
			
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
			String pcode=req.getParameter("pcode");
			
			al.forEach((k)->{
				if(pcode.equals(k.getpCode()))
				{
					k.setpPrice(Float.parseFloat(req.getParameter("pprice")));
					k.setpQty(Integer.parseInt(req.getParameter("pqty")));
					
					int z=new UpdateProductDAO().update(k);
					if(z>0)
					{
						pw.println("Product Update Successfully.....<br>");
					}
				}
			});
			
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);

		}
	}

}
