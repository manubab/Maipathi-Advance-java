package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeService {
	public int k = 0;

	public int insertData(Employee e) {
		Connection con = null;
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)");
			ps.setString(1, e.geteId());
			ps.setString(2, e.geteName());
			ps.setString(3, e.geteDesg());
			ps.setDouble(4, e.geteSal());
			k = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return k;
	}

	public ArrayList<Employee> al = new ArrayList<Employee>();

	public ArrayList<Employee> readData() {
		Connection con = null;
		ResultSet rs=null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");

			PreparedStatement ps = con.prepareStatement("select * from emp");
			rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.seteId(rs.getString("eid"));    //
				e.seteName(rs.getString("ename"));
				e.seteDesg(rs.getString("edesg"));
				e.seteSal(rs.getDouble("esal"));
				al.add(e);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
			rs.close();
			con.close();
			}
			catch(SQLException sql)
			{
				sql.printStackTrace();
			}
		}
		return al;
	}

	public int updateData(Employee e) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
			PreparedStatement ps = con.prepareStatement("update emp set ename=?,edesg=?,esal=? where eid=?");
			ps.setString(1, e.geteName());
			ps.setString(2, e.geteDesg());
			ps.setDouble(3, e.geteSal());
			ps.setString(4, e.geteId());
			k = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return k;

	}

	public int deleteData(String id) {
		Connection con = null;
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
			PreparedStatement ps = con.prepareStatement("delete from emp where eid=?");
			ps.setString(1, id);
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return k;
	}

}
