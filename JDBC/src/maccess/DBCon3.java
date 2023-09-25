package maccess;

import java.sql.*;
import java.util.*;
public class DBCon3 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;) {
			
			System.out.println("Enter emp id :");
			String eid=sc.nextLine();
			System.out.println("Enter emp name :");
			String ename=sc.nextLine();
			System.out.println("Enter emp desg :");
			String desg=sc.nextLine();
			
			System.out.println("Enter emp sal :");
			
			int sal=Integer.parseInt(sc.nextLine());
			
			
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		Statement stm=con.createStatement();
		
		int k=stm.executeUpdate("insert into emp52 values('"+eid+"','"+ename+"','"+desg+"',"+sal+")");
		
		if( k>0)
		{
			System.out.println("record inserted succesfully.....!");
		}
		
		ResultSet rs=stm.executeQuery("select sal from emp52");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
		}
		
		
		}
		catch(SQLIntegrityConstraintViolationException sq)
		{
			System.out.println("Record already inserted succesfully...!");
			
			
		}

		catch(InputMismatchException |SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
