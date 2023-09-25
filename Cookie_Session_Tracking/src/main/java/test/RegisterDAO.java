package test;
import java.sql.*;
public class RegisterDAO 
{
	int k=0;
	
	public int register(CustomerBean cb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
            ("insert into CustReg50 values(?,?,?,?,?,?)");
			ps.setString(1, cb.getCname());
			ps.setString(2, cb.getMid());
			ps.setLong(3, cb.getPhno());
			ps.setString(4, cb.getCity());
			ps.setString(5, cb.getState());
			ps.setInt(6, cb.getPincode());

			int k=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	

}
