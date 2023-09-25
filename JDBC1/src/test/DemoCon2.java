package test;
import java.sql.*;
import java.util.*;
public class DemoCon2 {

	public static void main(String[] args) {
		
		try {
			Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		
		PreparedStatement ps2=con.prepareStatement("select * from Product52",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		while(true)
		{
			System.out.println("====choice====="
					+ "\n\t1.Display normal"
					+ "\n\t2.Display reverse"
					+ "\n\t3.Display LastRow"
					+ "\n\t4.Display FirstRow"
					+ "\n\t5.Display SpecifiedRow"
					+ "\n\t6.exit"
					+ "\nEnter choice :");
			
			int choice=Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
			case 1:
				ResultSet rs1=ps2.executeQuery();
				
				
				
				while(rs1.next())
				{
					System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getInt(4));
					
				}
				
			
				
				break;
			case 2:
				ResultSet rs2=ps2.executeQuery() ;
				rs2.afterLast();
				while(rs2.previous())
				{
					System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));

				}
				break;
				
			case 3:
				
				ResultSet rs3=ps2.executeQuery();
				rs3.last();
				
				System.out.println(rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getFloat(3)+"\t"+rs3.getInt(4));

				
				break;
			case 4:
				ResultSet rs4=ps2.executeQuery();
				rs4.first();
				
				System.out.println(rs4.getString(1)+"\t"+rs4.getString(2)+"\t"+rs4.getFloat(3)+"\t"+rs4.getInt(4));

				break;
			case 5:
				ResultSet rs5=ps2.executeQuery();
				
				System.out.println("Enter choice Recored:");
				int cr=Integer.parseInt(sc.nextLine());
				rs5.absolute(cr);
				
				System.out.println(rs5.getString(1)+"\t"+rs5.getString(2)+"\t"+rs5.getFloat(3)+"\t"+rs5.getInt(4));

				
				break;
			case 6:
				System.out.println("operation stopped on table:");
				System.exit(0);
				
				break;
				
				default:
					System.out.println("invalid choice:");
				
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
