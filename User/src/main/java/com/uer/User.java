package com.uer;


import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class User extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		pw.println("Hello user");
		
	}
	

}
