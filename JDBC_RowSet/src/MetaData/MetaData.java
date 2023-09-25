package MetaData;

import java.sql.*;
import java.util.*;
import javax.sql.rowset.*;
import javax.sql.*;

public class MetaData 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				DatabaseMetaData bdms=con.getMetaData();
				System.out.println(bdms.getDatabaseProductVersion());
				
				PreparedStatement ps=con.prepareStatement("Select * from translogtab52");
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getLong(1)+"\t"+rs.getLong(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
				}
				
				ParameterMetaData pmd=ps.getParameterMetaData();
				
				System.out.println(pmd.getParameterCount());
				
				ResultSetMetaData rsd=rs.getMetaData();
				System.out.println(rsd.getColumnDisplaySize(3));
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
