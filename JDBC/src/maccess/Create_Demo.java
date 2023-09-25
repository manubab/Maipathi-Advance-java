package maccess;

import java.sql.*;
import java.util.*;

public class Create_Demo implements Runnable{
	static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static final String duName="System";
	static final String dPswd="tiger";
	
	public static void main(String args[])
	{
		
		try {
			Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection(url,duName,dPswd);
		
		PreparedStatement ps2=con.prepareStatement("insert into Manu52 values(?,?,?)");
		
	     System.out.println("Enter the name:");
	     String name=sc.nextLine();
	     System.out.println("Enter the age:");
	     int age=Integer.parseInt(sc.nextLine());
	     System.out.println("Enter the cno:");
	     long cno=Long.parseLong(sc.nextLine());
	     
	     ps2.setString(1, name);
	     ps2.setInt(2, age);
	     ps2.setLong(3, cno);
	     
	     int k1=ps2.executeUpdate();
	     
	     if(k1>0)
	     {
	    	 System.out.println("reocred inserted successfully....!");
	     }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
