package test;

import java.sql.*;
public class UpdateProfileDAO
{
	public int k=0;
	public int update(UserBean ub)
	{
		try
		{
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("update UserReg52 set  adds=?,mid=?,phno=? where uname=? and pswd=?");                                   
		ps.setString(1, ub.getAddr());
		ps.setString(2, ub.getmId());
		ps.setLong(3, ub.getPhNo());
		ps.setString(4,ub.getuName());
		ps.setString(5, ub.getpWord());
		k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

}
