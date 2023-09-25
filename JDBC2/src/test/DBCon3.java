package test;
import java.sql.*;
import java.util.*;

public class DBCon3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				Connection con=DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				PreparedStatement ps1=con.prepareStatement("insert into emp52 values(?,?,?,?)");
				System.out.println("Enter number of Employees");
				int n=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the"+n+" Employeee details");
				for(int i=1;i<=n;i++)
				{
					System.out.println("Enter "+i+" employee details");
					
					System.out.println("Enter the id");
					String id=sc.nextLine();
					System.out.println("Enter the name");
					String name=sc.nextLine();
					System.out.println("Enter the desg");
					String desg=sc.nextLine();
					System.out.println("Enter the sal");
					int sal=Integer.parseInt(sc.nextLine());
					ps1.setString(1, id);
					ps1.setString(2, name);
					ps1.setString(3, desg);
					ps1.setFloat(4, sal);
					ps1.addBatch();
				}
				int count[]=ps1.executeBatch();
				for(int i=0;i<count.length;i++)
				{
					System.out.println("Executed successfully");
				}
				ps1.clearBatch();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}
	}

}
