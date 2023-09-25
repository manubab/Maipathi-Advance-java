package test;

import java.sql.*;
import java.util.*;

public class Product_52 {
	public static void main(String[] args) {
		
		try {
			Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		PreparedStatement ps1=con.prepareStatement("insert into Product52 values(?,?,?,?)");
		
		PreparedStatement ps2=con.prepareStatement("select * from Product52");
		
		PreparedStatement ps3=con.prepareStatement("Select * from Product52 where pcode=?");
		
		PreparedStatement ps4=con.prepareStatement("update Product52 set pprice=?,pqty=pqty+? where pcode=?");
		
		PreparedStatement ps5=con.prepareStatement("delete from Product52 where pcode=?");
		
		while(true)
		{
			System.out.println("===== choice ====");
			System.out.println("\n\t1.Adding Product Details");
			System.out.println("\n\t2.Display All Product52 Details");
			System.out.println("\n\t3.view Based on pcode");
			System.out.println("\n\t4.update Based on pcode");
			System.out.println("\n\t5.delete Based on Pcode");
			System.out.println("\n\t6.Exit");
			System.out.println(" Enter choice :");
			int choice=Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
			case 1:
				// reading data 
				System.out.println("Enter the pcode:");
				String pcode=sc.nextLine();
				System.out.println("Enter the pname:");
				String pname=sc.nextLine();
				System.out.println("Enter the pprice:");
				float pprice=Float.parseFloat(sc.nextLine());
				System.out.println("Enter the pQty:");
				int pqty=Integer.parseInt(sc.nextLine());
				
				ps1.setString(1, pcode);
				ps1.setString(2, pname);
				ps1.setFloat(3, pprice);
				ps1.setInt(4, pqty);
				
				int k=ps1.executeUpdate();
				
				if(k>0)
				{
					System.out.println("Recored inserted Succesfully...!");
				}
				
				break;
			case 2:
				
				// retrieving data
				
				ResultSet rs=ps2.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
				}
				
				break;
			case 3:
				System.out.println("Enter the code:");
				String code=sc.nextLine();
				
				ps3.setString(1, code);
				
				ResultSet rs2=ps3.executeQuery();
				
				while(rs2.next())
				{
					System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));
				}
				
				break;
			case 4:
				System.out.println("Enter the pcode");
				String code2=sc.nextLine();
				ps3.setString(1, code2);
				ResultSet rs3=ps3.executeQuery();
				
				while(rs3.next())
				{
				System.out.println("old Price :"+rs3.getFloat(3));
				System.out.println("Enter new price");
				float nprice=Float.parseFloat(sc.nextLine());
				System.out.println("old pqty:"+rs3.getInt(4));
				System.out.println("Enter new Qty:");
				int nQty=Integer.parseInt(sc.nextLine());
				
				ps4.setFloat(1, nprice);
				ps4.setInt(2, nQty);
				ps4.setString(3, code2);
				
				int k1=ps4.executeUpdate();
				
				if(k1>0)
				{
					System.out.println("Recored updated Succesfully....!");
					
				}
				}
				break;
			case 5:
				System.out.println("Enter the pcode:");
				String code3=sc.nextLine();
				
				ps3.setString(1, code3);
				
				ResultSet rs4=ps3.executeQuery();
				
				while(rs4.next())
				{
					ps5.setString(1, code3);
					int k2=ps5.executeUpdate();
					
					if(k2>0)
					{
						System.out.println("recored deleted Succesfully ....!");
						
					}else {
						System.out.println("invalid pcode");
					}
					
				}
				break;
				
			case 6:
				System.out.println("Operation Stopped on Product52 ");
				System.exit(0);
				break;
				default:
					System.out.println("invalid choice....!");
			}
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
