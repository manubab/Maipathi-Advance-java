package test;

import java.sql.*;

public class DeleteProductDAO {
	public int k = 0;

	public int delete(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from product52 where pcode=?");

			ps.setString(1, pb.getpCode());
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
