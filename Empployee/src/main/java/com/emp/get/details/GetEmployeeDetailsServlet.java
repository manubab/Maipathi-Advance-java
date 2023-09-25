package com.emp.get.details;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GetEmployeeDetailsServlet extends GenericServlet {

	
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException
	{
		arg1.setContentType("text/html");
		PrintWriter pw=arg1.getWriter();
		
		ArrayList<Employee> employees= new EmployeeGetDetailsDAO().retrive();
		
		if(employees==null)
		{
			pw.println("Employeess details not Availble");
			
		}
		else
		{
			Iterator it=employees.iterator();
			
			while(it.hasNext())
			{
				Employee e=(Employee)it.next();
				
				pw.println("EmployeeId :"+e.getEmployeeId()+" <br> ");
				pw.println("EmployeeName :"+e.getEmployeeName()+" <br> ");
				pw.println("EmployeeDesgnation :"+e.getEmployeeDesignation()+" <br> ");
				pw.println("EmployeeSalary :"+e.getEmployeeSal()+" <br> ");
			}
		}
		
	}

}
