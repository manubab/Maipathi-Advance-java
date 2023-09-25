package test;
import java.sql.*;
import java.util.*;
public class DemoCon1 {
	
	public static void main(String[] args) {
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);		
		PreparedStatement ps2=con.prepareStatement("select * from product52",1004,1007);
		
		
		
		ResultSet rs1=stm.executeQuery("select * from Product52");
		rs1.afterLast();
//		if(rs1.first())
//		{
//			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getInt(4));	
//		}
		
		
		ResultSet rs2=ps2.executeQuery();
		
		if(rs2.next())
		{
			System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));	

		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
