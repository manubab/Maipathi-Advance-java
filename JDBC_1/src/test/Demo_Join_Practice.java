package test;
import java.sql.*;
import java.util.*;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
public class Demo_Join_Practice 
{
	public static void main(String[] args) 
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			
			PreparedStatement ps=con.prepareStatement
		   ("select * from empdetails52 e1,empsalary e2 where e1.eid=e2.eid");
			
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsm=rs.getMetaData();
			System.out.println(rsm.getColumnCount());
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(5)+"\t"+rs.getFloat(6)+"\t"+rs.getFloat(7)+"\n"+rs.getFloat(8));
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
