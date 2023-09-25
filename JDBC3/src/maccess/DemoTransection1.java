package maccess;

import java.sql.*;
import java.util.Date;
import java.util.*;

public class DemoTransection1
{
	
	static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static final String un="System";
	static final String pw="tiger";
	
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			try 
			{
				Connection con=DriverManager.getConnection(url,un,pw);
				
				PreparedStatement ps1=con.prepareStatement("select * from BankCustomer52 where accno=?");
				
				PreparedStatement ps2=con.prepareStatement("update BankCustomer52 set balence=balence+? where accno=?");
				
				
				PreparedStatement ps3=con.prepareStatement("insert into TransLogTab52 values(?,?,?,?)");
				
				
				System.out.println("commit Status :"+con.getAutoCommit());
				
				con.setAutoCommit(false);
				
				System.out.println("commit Status :"+con.getAutoCommit());

				Savepoint sp=con.setSavepoint();
				
				System.out.println("Enter the acnno");
				long hAccno=Long.parseLong(sc.nextLine());
				
				ps1.setLong(1, hAccno);
				
				ResultSet rs1=ps1.executeQuery();
				
				if(rs1.next())
				{
					float amt=rs1.getFloat(3);
					
					System.out.println("Enter benefiery acnoo");
					long bAccno=Long.parseLong(sc.nextLine());
					
					ps1.setLong(1, bAccno);
					
					ResultSet rs2=ps1.executeQuery();
					
					if(rs2.next())
					{
						System.out.println("Enter the bal:");
						float bal=Float.parseFloat(sc.nextLine());
						
						if(amt>bal)
						{
						   ps2.setFloat(1, -amt);
						   ps2.setLong(2, hAccno);
						   
						   int i=ps1.executeUpdate(); // updated in buffered
						   
						   ps2.setFloat(1, amt);
						   ps2.setLong(2, bAccno);
						   
						   int j=ps2.executeUpdate();  // updated in buffer
						   
						   if(i==1&&j==1)
						   {
							   
							   con.commit();
							 Date d=new Date();
							 
							 ps3.setLong(1,hAccno);
							 ps3.setLong(2, bAccno);
							 ps3.setFloat(3,amt);
							 ps3.setString(4, d.toString());
							 
							
							 
							int p=ps3.executeUpdate();
							
							if(p==1)
							{
								System.out.println("Transection completed....");
								con.commit();
								
							}
							 else
							   {
								   System.out.println("Transection failed....!");
								   
								   con.releaseSavepoint(sp);   
							   }
						   }
						  
						}else
						{
							System.out.println("insuffient balence...!");
						}
						
					}
					else
					{
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
