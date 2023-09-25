package test;

import java.sql.*;
import java.util.*;

public class Drop {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				
				PreparedStatement ps1=con.prepareStatement("drop table manu52");
				
				ResultSet rs1=ps1.executeQuery();

				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
