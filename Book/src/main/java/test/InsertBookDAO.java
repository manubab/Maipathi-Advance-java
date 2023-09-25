package test;

import java.sql.*;

public class InsertBookDAO {
	public int k=0;
	public int insert(BookBean bb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into BookDetails52 values(?,?,?,?,?)");
			ps.setString(1, bb.getbCode());
			ps.setString(2, bb.getbName());
			ps.setString(3,bb.getbAuthor());
			ps.setFloat(4, bb.getbPrice());
			ps.setInt(5, bb.getbQty());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

}
