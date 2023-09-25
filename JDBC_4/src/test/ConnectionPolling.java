package test;

import java.sql.*;
import java.util.Vector;

public class ConnectionPolling {

	public String dbUrl, uName, pWord;

	public ConnectionPolling(String dbUrl, String uName, String pWord) {
		this.dbUrl = dbUrl;
		this.uName = uName;
		this.pWord = pWord;
	}

	public Vector<Connection> v = new Vector<>();

	public void creatingConnections() {
		try {
			while (v.size() < 5) {
				System.out.println("pool is not full");
				Connection con = DriverManager.getConnection(dbUrl, uName, pWord);

				v.add(con);
				System.out.println(con);
			}

			if (v.size() == 5) {
				System.out.println("pool is full");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	public synchronized Connection useConnection()
	{
		Connection con=v.firstElement();
		v.removeElementAt(0);
		return con;
	}
	
	public synchronized void returnConnection(Connection con)
	{
		v.addElement(con);
		System.out.println("Connection added back to pool");
		
	}

}
