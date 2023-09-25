package test;


import java.util.*;
import java.sql.*;
import java.io.*;

public class DBCon1 
{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		try(sc;)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");   
				
				PreparedStatement ps=con.prepareStatement("insert into StreamTab52 values(?,?)");
				
				System.out.println("Enter the id");
				String id=sc.nextLine();
				
				ps.setString(1, id);
				
				System.out.println("Enter the file :");
				
				File f=new File(sc.nextLine());
				
				FileInputStream fis=new FileInputStream(f);
				
				ps.setBinaryStream(2, fis, f.length());
				
			int k=ps.executeUpdate();
				
			if(k>0)
			{
				System.out.println("Image inserted Successfully.....!");
			}
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
