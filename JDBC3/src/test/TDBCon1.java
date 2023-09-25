package test;

import java.sql.*;import java.util.*;

public class TDBCon1 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		try(sc;){
			
			try {
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				PreparedStatement ps1=con.prepareStatement("select * from BankCustomer52 where accno=?");
				
				PreparedStatement ps2=con.prepareStatement("update BankCustomer52 set cname=? where accno=?");
				
				System.out.println("Enter the hAccno");
				long hAccno=Long.parseLong(sc.nextLine());
				
				ps1.setLong(1, hAccno);
				
			   ResultSet rs1=ps1.executeQuery();	
			   
			   if(rs1.next())
			   {
				   String name=rs1.getString(2);
				   System.out.println("Enter the Benefiery accno");
				   long bAccno=Long.parseLong(sc.nextLine());
				   
				   ps1.setLong(1, bAccno);
				   
				   ResultSet rs2=ps1.executeQuery();
				   
				   if(rs2.next())
				   {
					  System.out.println("Enter the  new cname :");
					  String cname=sc.nextLine();
					  
					  ps2.setString(1, cname);
					  ps2.setLong(2, bAccno);
					  
					  int i=ps2.executeUpdate();
					  
					  if(i==1)
					  {
						  System.out.println("Transection Successfully");
					  }
					  
				   }else {
					   System.out.println("invalid bAccno");
				   }
				   
			   }else {
				   System.out.println("invalid hAccno");
			   }
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			
		}
	}

}
