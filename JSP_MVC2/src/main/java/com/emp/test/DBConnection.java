package com.emp.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
	private static Connection con=null;
	public DBConnection() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl:","system","tiger");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Connection getCon()
	{
		return con;
	}
	
	

}
