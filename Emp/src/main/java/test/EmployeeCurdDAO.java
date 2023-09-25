package test;

import java.sql.*;
import java.util.*;

public class EmployeeCurdDAO 
{
	public int k = 0;
	
	public int insertData(Employee e) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)");

			ps.setString(1, e.geteId());
			ps.setString(2, e.geteName());
			ps.setString(3, e.geteDesg());
			ps.setDouble(4, e.geteSal());
			k = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return k;
	}

	
	
	public ArrayList<Employee> al = new ArrayList<Employee>();
	public ArrayList<Employee> readData() {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.seteId(rs.getString(1));
				e.seteName(rs.getString(2));
				e.seteDesg(e.geteDesg());
				e.seteSal(e.geteSal());
				al.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
