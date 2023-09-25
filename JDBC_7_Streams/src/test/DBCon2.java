package test;

import java.sql.*;
import java.io.*;
import java.util.*;

public class DBCon2
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			try
			{	
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				PreparedStatement ps=con.prepareStatement("select * from StreamTab52 where id=?");
				
				System.out.println("Enter the id");
				
				String id=sc.nextLine();
				
				ps.setString(1,id);
				
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					Blob b=rs.getBlob(2);
					
					byte[] by=b.getBytes(1,(int)b.length());
					
					System.out.println("Enter fpath&fname(destination)");
					
					File f=new File(sc.nextLine());
					
					FileOutputStream fos=new FileOutputStream(f);
					
					fos.write(by);
					
					System.out.println("image retrived Successfully");
					
					
					
					
					
				}else {
					System.out.println("invalid id");
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
