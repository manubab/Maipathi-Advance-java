package test;
import java.sql.*;
public class InsertProductDAO 
{
	int k=0;
	
	public int insert(ProductBean pb)
	{
		try
		{
			Connection con=DBConnection.getCon(); // accessing DB Connection
			
			PreparedStatement ps1=con.prepareStatement("insert into product52 values(?,?,?,?)");  
			
			ps1.setString(1, pb.getpCode());
			ps1.setString(2, pb.getpName());
			ps1.setFloat(3, pb.getpPrice());
			ps1.setInt(4, pb.getpQty());
			
			k=ps1.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}

}
