package test;

import java.sql.*;
import java.util.*;

public class RetriveEmployeeDAO
{
	public ArrayList<Employee> al=new ArrayList<Employee>();
	
	public ArrayList<Employee> retrive()
	{
		try
		{
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("select * from employee");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Employee e=new Employee();
				
				e.setId(rs.getString(1));
				e.setName(rs.getString(2));
				e.setDesg(rs.getString(3));
				e.setSal(rs.getString(4));
				
				al.add(e);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
		
	
	
	
	

}
