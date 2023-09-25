package maccess;
import java.sql.*;
import java.util.*;
public class TransLog_Demo {
	
	static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static final String un="System";
	static final String pw="tiger";
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		try {
			
			System.out.println("Enter the hAccno");
			long hAccno=Long.parseLong(sc.nextLine());
			
			Connection con=DriverManager.getConnection(url,un,pw);
			
			PreparedStatement ps1=con.prepareStatement("select * from TransLogTab52 where hAccno=?");
			
			ps1.setLong(1,hAccno );
			
			ResultSet rs1=ps1.executeQuery();
			
			if(rs1.next())
			{
				System.out.println(rs1.getLong(1)+"\t"+rs1.getLong(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getString(4));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
