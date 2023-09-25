package test;

import java.sql.*;

public class UpdateProfileDAO {
	public int k = 0;
	public int update(CustBean cb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update Customerreg52 set addr=?,mid=?,phno=?  where cname=? and pword=?");
			ps.setString(1, cb.getAddr());
			ps.setString(2, cb.getmId());
			ps.setLong(3, cb.getPhNo());
			ps.setString(4, cb.getuName());
			ps.setString(5, cb.getpWord());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;

	}

}
