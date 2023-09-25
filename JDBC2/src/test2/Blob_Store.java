package test2;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Blob_Store 
{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			try
			{
				Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				PreparedStatement ps1=con.prepareStatement("insert into Stream52 values(?,?)");
				
				System.out.println("Enter the id");
				String id=sc.nextLine();
				
				ps1.setString(1, id);
				
				System.out.println("Enter the fpath&fname:(Source)");
				
				File f1=new File(sc.nextLine());
				
				if(f1.exists())
				{
					FileInputStream fis=new FileInputStream(f1);
					
					ps1.setBinaryStream(2, fis,(int)f1.length());
					
					int k=ps1.executeUpdate();
					
					if(k>0)
					{
						System.out.println("file Stored Successfully");
						
					}
					
				}else {
					System.out.println("invalid file");
				}
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	

}
