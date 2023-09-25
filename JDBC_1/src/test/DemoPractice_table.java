package test;
import java.sql.*;

public class DemoPractice_table
{
	public static void main(String[] args) {
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		PreparedStatement ps=con.prepareStatement("create table Manu5(id varchar2(10),name varchar2(10),phno number(10))");
		
		int k=ps.executeUpdate();
		if(k==0)
		{
			System.out.println("table created Successfully");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

}
