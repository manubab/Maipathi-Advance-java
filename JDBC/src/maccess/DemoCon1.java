package maccess;
import java.sql.*;
public class DemoCon1 {	
	public static void main(String [] args)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger"); //create connection
		
		Statement stm=con.createStatement();  //create Statement 
		
		ResultSet rs=stm.executeQuery("select * from emp52");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
