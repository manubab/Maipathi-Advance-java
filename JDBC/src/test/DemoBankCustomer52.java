package test;

import java.sql.*;
import java.util.*;

public class DemoBankCustomer52 {
	public static void main(String[] args) {
		
		try {
			Scanner sc=new Scanner(System.in);
			
			
			
			
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		PreparedStatement ps1=con.prepareStatement("insert into BankCustomer52 values(?,?,?,?)");
		
		PreparedStatement ps2=con.prepareStatement("select * from BankCustomer52");
		
		
		while(true)
		{
			System.out.println("=========choice========");
			System.out.println("\n\t1.addBankDetails");
			System.out.println("\n\t2.view AllBankCustomerDetails");
			System.out.println("\n\t3.exit");
			System.out.println("Enter choice:");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				
				System.out.println("Enter the accNO:");
				long accNo=Long.parseLong(sc.nextLine());
				System.out.println("Enter the cName:");
				String cName=sc.nextLine();
				System.out.println("Enter the balence:");
				int bal=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the accType:");
				String accType=sc.nextLine();
				
				ps1.setLong(1, accNo);
				ps1.setString(2, cName);
				ps1.setFloat(3, bal);
				ps1.setString(4, accType);
				
				int k=ps1.executeUpdate();
				
				if(k>0)
				{
					System.out.println("recored inserted succesfully");
					
				}
				else {
					System.out.println("plese enter valid details....!");
				}
				
				break;
			case 2:
				
				ResultSet rs1=ps2.executeQuery();
				
				while(rs1.next())
				{
					System.out.println(rs1.getLong(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getString(4));
				}
				
				break;
			case 3:
				System.out.println("OPeration stopped on BankCustomer52");
				System.exit(0);
				
				default:
					System.out.println("invaid choice....!");
				
			}
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
