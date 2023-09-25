package access;

import java.sql.*;

public class DBCon8 {

	public static void main(String[] args) {
		
		ConnectionPolling cp=new ConnectionPolling("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		cp.createConnection();
		
		System.out.println("============ Use1 ===========");
		
		Connection con1=cp.useConnection();
		
		
		
		System.out.println("Size :"+cp.v.size());
		
		try {
			PreparedStatement ps1=con1.prepareStatement("select * from emp52");
			
			ResultSet rs1=ps1.executeQuery();
			
			while(rs1.next())
			{
			
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getFloat(4));
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("================ user-2 ===============");
		
		Connection con2=cp.useConnection();
		
		System.out.println("Size :"+cp.v.size());
		
		
		try {
			PreparedStatement ps1=con2.prepareStatement("select * from product52");
			
			ResultSet rs2=ps1.executeQuery();
			
			while(rs2.next())
			{
				System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("---user-1-----");
		cp.returnConnection(con1);
		System.out.println("Size :"+cp.v.size());
		System.out.println("---- user2 -----");
		cp.returnConnection(con2);
		System.out.println("Size :"+cp.v.size());
		
		
		cp.v.forEach((k)->System.out.println(k));
		
		
		
		
		
		
	}

}
