package com.emp.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductDAO {
	public static DBConnection db = new DBConnection();
	public ArrayList<ProductBean> al = new ArrayList<>();

	public ArrayList<ProductBean> retrive() {
		try {
			Connection con = db.getCon();
			PreparedStatement ps = con.prepareStatement("select * from product52");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setCode(rs.getString("pcode"));
				pb.setName(rs.getString("pname"));
				pb.setPrice(rs.getFloat("pprice"));
				pb.setQty(rs.getInt("pqty"));
				al.add(pb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
