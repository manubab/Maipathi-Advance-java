package test;

import java.sql.*;
import javax.sql.*;
import java.util.*;

public class DBCon10 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			try
			{
				
				System.out.println("Enter the CustID");
				String cid=sc.nextLine();
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				CallableStatement cs=con.prepareCall("{call c1(?,?,?,?,?,?,?,?,?)}");
				
				cs.setString(1, cid);
				
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.INTEGER);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.BIGINT);
				
				cs.execute();
				
				
				System.out.println("FName :"+cs.getString(2));
				System.out.println("LName :"+cs.getString(3));
				System.out.println("HNO :"+cs.getString(4));
				System.out.println("StreatName :"+cs.getString(5));
				System.out.println("City :"+cs.getString(6));
				System.out.println("pcode :"+cs.getInt(7));
				System.out.println("MailID :"+cs.getString(8));
				System.out.println("PhNo :"+cs.getLong(9));
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
