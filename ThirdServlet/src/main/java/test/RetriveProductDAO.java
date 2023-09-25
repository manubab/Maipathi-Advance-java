package test;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
public class RetriveProductDAO 
{
	public ArrayList<ProductBean> al=new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> retrive()
	{
		try
		{
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("select * from product52");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				ProductBean pb=new ProductBean();
				pb.setpCode(rs.getString(1));
				pb.setpName(rs.getString(2));
				pb.setpPrice(rs.getFloat(3));
				pb.setpQty(rs.getInt(4));
				
				al.add(pb); //Bean Object added to ArrayList
			} //end of loop
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	

}
