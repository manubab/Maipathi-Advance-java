package test;

import java.sql.*;
import java.util.*;

public class DemoPractice {

	public static void main(String[] args) {
		
		try {
			Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection
				
	("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		
		PreparedStatement ps1=con.prepareStatement("insert into BookDetails50 values(?,?,?,?,?)");
		
		PreparedStatement ps2=con.prepareStatement("select * from Bookdetails50");
		
		PreparedStatement ps3=con.prepareStatement("select * from Bookdetails50 where code=?");
		
		PreparedStatement ps4=con.prepareStatement("update BookDetails50 set price=?,qty=qty+? where code=?");
		
		PreparedStatement ps5 =con.prepareStatement("delete from BookDetails50 where code=?");
		
		
		
		System.out.println("***** Choice *****");
		
		System.out.println("\t1.AddBookDetails"
				+ "\n\t2.viewAllBookDetails"
				+ "\n\t3.viewBookByCode"
				+ "\n\t4.UpdateBookDetails(price/qty"
				+ "\n\t5.DeleteBookByCode"
				+ "\n\t6.exit");
		
		
		System.out.println("Enter choice :");
		
		int choice=Integer.parseInt(sc.nextLine());
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter the BookCode :");
			String code=sc.nextLine();
			System.out.println("Enter BookName :");
			String name=sc.nextLine();
			System.out.println("Enter Bookauthor");
			String author=sc.nextLine();
			System.out.println("Enter BookPrice :");
			float price=Float.parseFloat(sc.nextLine());
			System.out.println("Enter Bookqty ");
			int qty=sc.nextInt();
			
			// adding data to PreparedStatement Object 
			
			ps1.setString(1, code);
			ps1.setString(2, name);
			ps1.setString(3, author);
			ps1.setFloat(4, price);
			ps1.setInt(5, qty);
			
			int k=ps1.executeUpdate();
			
			if(k>0)
			{
				System.out.println("BookDetails Inserted ....!");
				
			}
			
			break;
		case 2:
			     ResultSet rs=ps2.executeQuery();
			     
			     while(rs.next())
			     {
			    	 System.out.println(rs.getString(1)+
			    			 "\t"+rs.getString(2)+
			    			 "\t"+rs.getString(3)+
			    			 "\t"+rs.getFloat(4)+
			    			 "\t"+rs.getInt(5));
			    	 
			     }
			     
			break;
		case 3:
			
			System.out.println("Enter the BookCode :");
			String bcode=sc.nextLine();
			
			ps3.setString(1, bcode);
			
          ResultSet rs2=ps3.executeQuery();			
			if(rs2.next())
			{
				System.out.println(rs2.getString(1)
						+"\t"+rs2.getString(2)
						+"\t"+rs2.getString(3)
						+"\t"+rs2.getFloat(4)
						+"\t"+rs2.getInt(5));
			}
			else {
				System.out.println("invalid bookCode....!");
			}
			
			break;
		case 4:
			System.out.println("Enter the BookCode :");

			String bcode2=sc.nextLine();
			
			ps3.setString(1, bcode2);
			
		     
			ResultSet rs3=ps3.executeQuery();
			
			if(rs3.next())
			{
				System.out.println("Old price :"+rs3.getFloat(4));
				
				System.out.println("Enter newPrice");
				
				float nPrice=Float.parseFloat(sc.nextLine());
				
				System.out.println("Existing qty:"+rs3.getInt(5));
				
				System.out.println("Enter the Qty :");
				
				int nQty=Integer.parseInt(sc.nextLine());
				
				ps4.setFloat(1, nPrice);
				
				ps4.setInt(2, nQty);
				ps4.setString(3, bcode2);
				
				int k1=ps4.executeUpdate();
				
				if(k1>0)
				{
					System.out.println("BookedDetails Updated ....!");
				}
				else
				{
					System.out.println("Invalid BookCode...!");
					
				}
			}
			
			
			break;
		case 5:
			
			System.out.println("Enter the BookCode :");
			String bcode3=sc.nextLine();
		    
			ps3.setString(1, bcode3);
			
			ResultSet rs4=ps3.executeQuery();
			
			if(rs4.next())
			{
				ps5.setString(1, bcode3);
				int k3=ps5.executeUpdate();
				
				if(k3>0)
				{
					System.out.println("BookDetails deleted ....!");
				}
				
				
			}
			else {
				System.out.println("invalid BookCode...!");
			}
			 
			
			
			break;
		case 6:
			System.out.println("Operation Stopped :");
			System.exit(0);
			
			default :
				System.out.println("invaid choice...!");
		}
		
		
		
		
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		}
	

}
