package test;

import java.sql.*;
import java.util.*;


public class DBCon12 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			try 
			{
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				CallableStatement cs=con.prepareCall("{call ?:= f1(?)}");
				
			
				cs.registerOutParameter(1, Types.BIGINT);
				System.out.println("Enter the Cust Id:");
				String cid=sc.nextLine();
				
				cs.setString(2, cid);
				
				cs.execute();
				
				System.out.println("Cust id :"+cid);
				
				System.out.println("phno :" +cs.getLong(1));
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
