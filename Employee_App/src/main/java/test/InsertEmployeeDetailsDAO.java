package test;

import java.sql.*;

public class InsertEmployeeDetailsDAO
{
	public int k=0;
	
	public int Insert(Employee e)
	{
		try
		{
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?)");
			
			ps.setString(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getDesg());
			ps.setString(4, e.getSal());
			
			k=ps.executeUpdate();
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return k;
		
	}

}
