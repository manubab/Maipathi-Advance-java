package test;

import java.sql.*;
import javax.servlet.http.*;

public class UpdateProductDAO {
	public int z = 0;

	public int update(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update product52 set pprice=?,pqty=? where pcode=?");
			ps.setFloat(1, pb.getpPrice());
			ps.setInt(2, pb.getpQty());
			ps.setString(3, pb.getpCode());

			z = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return z;
	}

}
