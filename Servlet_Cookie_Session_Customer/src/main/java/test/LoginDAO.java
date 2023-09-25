package test;

import java.sql.*;
import javax.servlet.http.*;

public class LoginDAO {
	public CustBean cb = null;

	public CustBean login(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from customerreg52 where cname=? and pword=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cb = new CustBean();
				cb.setuName(rs.getString(1));
				cb.setpWord(rs.getString(2));
				cb.setfName(rs.getString(3));
				cb.setlName(rs.getString(4));
				cb.setAddr(rs.getString(5));
				cb.setmId(rs.getString(6));
				cb.setPhNo(rs.getLong(7));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}

}
