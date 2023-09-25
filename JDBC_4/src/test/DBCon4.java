package test;
import java.sql.*;
import java.util.*;

public class DBCon4 {
	public static void main(String[] args) {
		
		
		try {
			
		
		ConnectionPolling cp=new ConnectionPolling("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
	 	cp.creatingConnections();
		System.out.println("size of pool :"+cp.v.size());
		
		System.out.println(" **** user-1 ****");
		
		Connection con1=cp.useConnection();
		System.out.println(con1);
		
		System.out.println("size of pool :"+cp.v.size());
		
		System.out.println("**** user2 -1 ****");

		Connection con2=cp.useConnection();
		
		System.out.println(con2);
		System.out.println("size of pool :"+cp.v.size());
		
		System.out.println("*** user-1 ****");
		cp.returnConnection(con1);
		
		System.out.println("size of pool :"+cp.v.size());
		
		System.out.println("**** user-2 ****");
		
		cp.returnConnection(con2);
		
		System.out.println("size of pool :"+cp.v.size());

		System.out.println("====== Display Connection from pool ====");
		Iterator<Connection> it=cp.v.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
			
		}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
