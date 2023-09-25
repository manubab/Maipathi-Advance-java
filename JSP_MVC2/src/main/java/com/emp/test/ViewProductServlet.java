package com.emp.test;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		ArrayList<ProductBean> al=new ViewProductDAO().retrive();
		
		if(al.size()==0)
		{
			req.setAttribute("msg", "product details not availble......!");
			req.getRequestDispatcher("Response.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("al", al);
			req.getRequestDispatcher("ViewProducts.jsp").forward(req, res);
		}
	}

}
