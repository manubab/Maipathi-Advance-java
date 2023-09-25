package test2;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Blob_Retrive {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
			
			PreparedStatement ps1=con.prepareStatement("select * from stream52 where id=?");
			
			System.out.println("Enter the id");
			
			String id=sc.nextLine();
			
			ps1.setString(1,id);
			
			ResultSet rs1=ps1.executeQuery();
			
			if(rs1.next())
			{
				Blob b=rs1.getBlob(2);
				
				byte by[]= b.getBytes(1, (int)b.length());
				
				// Stream converted into byte Array;
				
				System.out.println("Enter fpath&fname:(destination)");
				
				File f=new File(sc.nextLine());
				
				FileOutputStream fos=new FileOutputStream(f);
				
				fos.write(by);
				
				System.out.println("Stream retrived Successfully");
				
			}
			else {
				System.out.println("Invalid id ");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}

}
