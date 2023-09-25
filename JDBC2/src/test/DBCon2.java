package test;
import java.sql.*;
import java.util.*;

public class DBCon2 {
	
	

		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
			try(sc) {
				
				try {
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				Statement stm=con.createStatement();
				
				// insert inserting  
				
				System.out.println("Enter the inserting data :");
				
				
				System.out.println("Enter the pcode:");
				String code=sc.nextLine();
				System.out.println("Enter tge pname");
				String name=sc.nextLine();
				System.out.println("Enter the pprice");
				float pprice=Float.parseFloat(sc.nextLine());
				System.out.println("Enter the pqty");
				int pqty=Integer.parseInt(sc.nextLine());
				
				// delete data
				System.out.println("delete record id:");
				System.out.println("Enter the pcode");
				String cd=sc.nextLine();
				
				stm.addBatch("insert into product52 values('"+code+"','"+name+"',"+pprice+","+pqty+")");
				
	           stm.addBatch("delete from emp52 where id='"+cd+"'");
				
				
				int k[]=stm.executeBatch();
				
				for(int i=0;i<k.length;i++)
				{
					System.out.println("Executed successfully");
				}
				
				stm.clearBatch();
				
				con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}

		}

	


}
