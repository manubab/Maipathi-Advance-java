package MetaData;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.sql.rowset.*;

public class DBCon2 
{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		try
		{
			Connection con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
			
			
			DatabaseMetaData dmd=con.getMetaData();
			System.out.println("Version :"+dmd.getDatabaseProductVersion());
			
			RowSetFactory rsf=RowSetProvider.newFactory();
			
			JdbcRowSet ob=rsf.createJdbcRowSet();
			
			PreparedStatement ps=con.prepareStatement("insert into emp values(?,?)");
		
			ParameterMetaData pmd=ps.getParameterMetaData();
			
			System.out.println("count :"+pmd.getParameterCount());
			
			PreparedStatement ps1=con.prepareStatement("select * from Product52");
			
			ResultSet rs1=ps1.executeQuery();
			
			ResultSetMetaData rsmt=rs1.getMetaData();
			
			while(rs1.next())
			{
				System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getInt(3)+"\t"+rs1.getInt(4));
			}
			
			System.out.println("count :"+rsmt.getColumnCount());
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
