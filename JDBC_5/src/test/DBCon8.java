package test;

import java.sql.*;
import java.util.*;

public class DBCon8 {

	public static void main(String[] args) {
     
		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			try
			{
				
				System.out.println("Enter the CustID");
				String cid=sc.nextLine();
				System.out.println("Enter the CustFirstName");
				String fName=sc.nextLine();
				System.out.println("Enter the CustLastName");
				String lName=sc.nextLine();
				System.out.println("Enter the hNo");
				String hNo=sc.nextLine();
				System.out.println("Enter the sName");
				String sName=sc.nextLine();
				System.out.println("Enter the city");
				String cty=sc.nextLine();
				System.out.println("Enter the pcode");
				int pcode=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the CustMailId");
				String md=sc.nextLine();
				System.out.println("Enter the CustPhoneNumber");
				long pno=Long.parseLong(sc.nextLine());
				
				Connection con=DriverManager.getConnection
				
			   ("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				CallableStatement cs=con.prepareCall
				
			("{call CustInsert52(?,?,?,?,?,?,?,?,?)}");
				
				cs.setString(1, cid);
				cs.setString(2, fName);
				cs.setString(3, lName);
				cs.setString(4, hNo);
				cs.setString(5, sName);
				cs.setString(6, cty);
				cs.setInt(7, pcode);
				cs.setString(8, md);
				cs.setLong(9, pno);
				
				
				cs.execute();
				
				System.out.println(" Procedure executed successfully.....!");
				
				System.out.println("CustData upated....");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
