package maccess;

import java.sql.*;

public class DBCon2 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger");
			Statement stm=con.createStatement();
			
			int k=stm.executeUpdate("insert into emp52 values('"+"A1111"+"','"+"Sai"+"','"+"se"+"',"+13000+")");
			
			if(k>0)
			{
				System.out.println("record inserted succesfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
