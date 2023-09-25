package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

public class CustomerLoginDAO
{
	public CustomerBean cb=null;
	public CustomerBean login(HttpServletRequest req)
	{
		Connection con=DBConnection.getCon();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from Custreg50 where cname=? and phno=?");
			ps.setString(1, req.getParameter("cname"));
			ps.setLong(2, Long.parseLong(req.getParameter("phno")));
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				cb=new CustomerBean(); 
				
				cb.setCname(rs.getString(1));
				cb.setMid(rs.getString(2));
				cb.setPhno(rs.getLong(3));
				cb.setCity(rs.getString(4));
				cb.setState(rs.getString(5));
				cb.setPincode(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return cb;
	}

}
