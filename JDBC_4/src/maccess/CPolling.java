package maccess;

import java.sql.*;
import java.util.Vector;;

public class CPolling
{
	public String dbUrl,uName,pWord;
	
	public CPolling(String dbUrl,String uName,String pWord)
	{
		this.dbUrl=dbUrl;
		this.uName=uName;
		this.pWord=pWord;
		
	}
	
	public void createConnections()
	{
		try {
		
			
		Vector<Connection> v=new Vector<Connection>();
		
		while(v.size()<5) {
			
		
		Connection con=DriverManager.getConnection(dbUrl,uName,pWord);
		System.out.println("Pool is not full");
		v.add(con);
		
		System.out.println(con);
		
		}
		if(v.size()==5)
		{
			System.out.println("pool is full");
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
