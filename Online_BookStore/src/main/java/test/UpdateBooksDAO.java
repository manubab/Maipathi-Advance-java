package test;
import java.io.*;
import java.sql.*;
public class UpdateBooksDAO
{
	public int z=0;
	
	public int update(BookBean bb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update BookDetails52 set bprice=?,bqty=? where bcode=?");
			ps.setFloat(1, bb.getbPrice());
			ps.setInt(2, bb.getbQty());
			ps.setString(3, bb.getbCode());
			
			z=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
	}

}
