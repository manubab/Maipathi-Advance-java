package test;

import java.sql.*;

public class DeleteBooksDAO {
	public int k = 0;

	public int delete(BookBean bb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from BookDetails52 where bcode=?");
			ps.setString(1, bb.getbCode());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
