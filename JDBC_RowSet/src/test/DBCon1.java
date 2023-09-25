package test;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.sql.rowset.*;

public class DBCon1 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		try
		{
			RowSetFactory rsf=RowSetProvider.newFactory();
			
			System.out.println("===== choice ======");
			
			System.out.println("\t1.JdbcRowSet"
					+ "\n\t2.CachedRowSet");
			System.out.println("Enter the Choice");
			
			switch(sc.nextInt())
			{
			case 1:
				
				JdbcRowSet jrs=rsf.createJdbcRowSet();
				jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
				jrs.setUsername("System");
				jrs.setPassword("tiger");
				
				jrs.setCommand("select * from emp");
				
				jrs.execute();
				
				while(jrs.next())
				{
					System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2));
				}
				jrs.close();
				break;
				
			case 2:
				
				CachedRowSet crs=rsf.createCachedRowSet();
				
				crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
				crs.setUsername("System");
				crs.setPassword("tiger");
				
				crs.setCommand("Select * from emp");
				
				crs.execute();
				
				while(crs.next())
				{
					System.out.println(crs.getInt(1)+"\t"+crs.getString(2));
					
					
				}
				crs.close();
				break;
				
				default:
					System.out.println("Invalid Choice....");
				
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
