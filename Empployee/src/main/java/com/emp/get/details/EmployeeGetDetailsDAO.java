package com.emp.get.details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeGetDetailsDAO {
	ArrayList<Employee> employees = new ArrayList<Employee>();

	public  ArrayList<Employee> retrive() {

		try {
			DBConnection db = new DBConnection();
			Connection con = db.getCon();

			PreparedStatement ps = con.prepareStatement("select * from emp");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Employee e=new Employee();
				e.setEmployeeId(rs.getString("eid"));
				e.setEmployeeName(rs.getString("ename"));
				e.setEmployeeDesignation(rs.getString("edesg"));
				e.setEmployeeSal(rs.getFloat("esal"));
				
				employees.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;

	}

}
