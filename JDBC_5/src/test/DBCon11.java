package test;
 
import java.sql.*;
import java.util.*;
import javax.sql.*;


public class DBCon11 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		try(sc;)
		{
			
			try
			{
				System.out.println("Enter the emm id");
				String eid=sc.nextLine();
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				CallableStatement cs=con.prepareCall("{call e1(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
				cs.setString(1, eid);
				
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.INTEGER);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.BIGINT);
				cs.registerOutParameter(10, Types.INTEGER);
				cs.registerOutParameter(11, Types.INTEGER);
				cs.registerOutParameter(12, Types.INTEGER);
				cs.registerOutParameter(13, Types.INTEGER);
				
				cs.execute();
				
				System.out.println("Emp Name :"+cs.getString(2));
				System.out.println("EMp Desg :"+cs.getString(3));
				System.out.println("HNO :"+cs.getString(4));
				System.out.println("Streat Name :"+cs.getString(5));
				System.out.println("City :"+cs.getString(6));
				System.out.println("pcode :"+cs.getInt(7));
				System.out.println("MailId :"+cs.getString(8));
				System.out.println("PhNo :"+cs.getLong(9));
				System.out.println("Bsal :"+cs.getFloat(10));
				System.out.println("HRA :"+cs.getFloat(11));
				System.out.println("DA :"+cs.getFloat(12));
				System.out.println("TotalSal :"+cs.getFloat(13));
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}

}
