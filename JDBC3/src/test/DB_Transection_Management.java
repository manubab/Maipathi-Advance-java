package test;

import java.sql.*;
import java.util.*;

public class DB_Transection_Management 
{
	
	public static void main(String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    
	    try(sc;)
	    {
	    	try
	    	{
	    		Connection con=DriverManager.getConnection
	    		("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
	    		
	    		PreparedStatement ps1=con.prepareStatement("select * from BankCustomer52 where accno=?");
	    		
	    	    PreparedStatement ps2=con.prepareStatement("update BankCustomer52 set balence=balence+? where accno=?");
	    	    
	    	    
	    	    System.out.println("Commit status :"+con.getAutoCommit());
	    	    
	    	    con.setAutoCommit(false);
	    	    
	    	    System.out.println("Commit status:"+con.getAutoCommit());
	    	    
	    	    
	    	    Savepoint sp=con.setSavepoint();
	    	    
	    	    System.out.println("Enter the home accno");
	    	    
	    	    long hAccno=Long.parseLong(sc.nextLine());
	    	    
	    	    ps1.setLong(1, hAccno);
	    	    
	    	    ResultSet rs1=ps1.executeQuery();
	    	    
	    	    if(rs1.next())
	    	    {
	    	    	float bal=rs1.getFloat(3);
	    	    	
	    	    	System.out.println("Enter benefieciry Accno:");
	    	    	long bAccno=Long.parseLong(sc.nextLine());
	    	    	
	    	    	ps1.setLong(1,bAccno);
	    	    	
	    	    	ResultSet rs2=ps1.executeQuery();
	    	    	
	    	    	if(rs2.next())
	    	    	{
	    	    		System.out.println("Enter the amt to be transferred");
	    	    		float amt =Float.parseFloat(sc.nextLine());
	    	    		
	    	    		if(amt<=bal)
	    	    		{
	    	    			ps2.setFloat(1, -amt);
	    	    			ps2.setLong(2, hAccno);
	    	    			
	    	    			int i=ps2.executeUpdate(); // buffered Updated 
	    	    			
	    	    			ps2.setFloat(1, amt);
	    	    			ps2.setLong(2, bAccno);
	    	    			
	    	    			int j=ps2.executeUpdate(); // Buffer Updated
	    	    			
	    	    			if(i==1&&j==1)
	    	    			{
	    	    				con.commit();
	    	    				System.out.println("Transection Successfull");
	    	    				
	    	    			}else {
	    	    				
	    	    			}
	    	    			
	    	    		}else {
	    	    			System.out.println("insufficient fund...");
	    	    			
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
