package test;
import java.sql.*;
import java.util.*;

public class DBCon13 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			try
			{
				System.out.println("Enter the Emp Id");
				String eid=sc.nextLine();
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");

				
				CallableStatement cs=con.prepareCall("{call ?:=f2(?)}");
				
				cs.registerOutParameter(1, Types.FLOAT);
				cs.setString(2, eid);
				
				cs.execute();
				
				System.out.println("Eid :"+eid);
				System.out.println("TotalSal :"+cs.getFloat(1));
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
