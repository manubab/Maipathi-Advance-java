package test;

import java.sql.*;


public class AdminRegisterDAO
{
	int n=0;
	public int register(Admin ab)
	{
		
		try
		{
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("insert into ar values(?,?,?,?,?)");
			
			ps.setString(1, ab.getAdminFirstName());
			ps.setString(2, ab.getAdminLastName());
			ps.setString(3,ab.getAdminMail());
			ps.setString(4,ab.getPassword());
			ps.setInt(5, ab.getContact());
			
			
			int n=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
		
		
		
	}

}
