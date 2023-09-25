package maccess;

import java.util.*;
import java.sql.*;

public class StudentDetails52 {
	
	static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static final String duname="System";
	static final String dpswd="tiger";
	public static void main(String[] args) {
		
		try {
		Scanner sc=new Scanner(System.in);	
		
		Connection con=DriverManager.getConnection(url,duname,dpswd);
		
		PreparedStatement ps1=con.prepareStatement("insert into Student52Marks values(?,?,?,?,?,?)");
		
		PreparedStatement ps2=con.prepareStatement("insert into Student52 values(?,?,?,?,?)");
		
		PreparedStatement ps3=con.prepareStatement("select * from Student52");
		
		PreparedStatement ps4=con.prepareStatement("select * from student52 where rollNo=?");
		
		
		while(true)
		{
			System.out.println("==== choice ====="
					+ "\n\t1.Add Student Details"
					+ "\n\t2.view All Student Details"
					+ "\n\t3.view Student by rollNo"
					+ "\n\t4.exit"
					+ "\nEnter choice:");
			
			
			
			
			int choice=Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter the rollNo:");
				String rollNo=sc.nextLine();
				System.out.println("Enter the name");
				String name=sc.nextLine();
				System.out.println("Enter the branch");
				String branch=sc.nextLine();
				
				System.out.println("Read 6 subect marks :");
				
				System.out.println("Enter subject 1 marks:");
				int sub1=Integer.parseInt(sc.nextLine());
				System.out.println("Enter subject 2 marks:");
				int sub2=Integer.parseInt(sc.nextLine());
				System.out.println("Enter subject 3 marks:");
				int sub3=Integer.parseInt(sc.nextLine());
				System.out.println("Enter subject 4 marks:");
				int sub4=Integer.parseInt(sc.nextLine());
				System.out.println("Enter subject 5 marks:");
				int sub5=Integer.parseInt(sc.nextLine());
				System.out.println("Enter subject 6 marks:");
				int sub6=Integer.parseInt(sc.nextLine());
				
				ps1.setInt(1,sub1);
				ps1.setInt(2,sub2);
				ps1.setInt(3,sub3);
				ps1.setInt(4,sub4);
				ps1.setInt(5,sub5);
				ps1.setInt(6,sub6);
				
				int k=ps1.executeUpdate();
				
				if(k>0)
				{
					System.out.println("marks inseted successully..!");
				}
				
				int totalMarks=sub1+sub2+sub3+sub4+sub5+sub6;
				
				float per=(totalMarks/6);
				
				
				
				
				ps2.setString(1, rollNo);
				ps2.setString(2,name);
				ps2.setString(3, branch);
				ps2.setInt(4, totalMarks);
				ps2.setFloat(5, per);
				
				
				int k1=ps2.executeUpdate();
				
				if(k1>0)
				{
					System.out.println("Student details inserted successfully....!");
				}
				
				
				
				break;
			case 2:
				
				ResultSet rs=ps3.executeQuery();
				
				if(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getFloat(5));
				}
				
				break;
			case 3:
				
				System.out.println("Enter the rollNo:");
				String rN=sc.nextLine();
				
				ps4.setString(1,rN);
				
				ResultSet rs1=ps4.executeQuery();
				
				if(rs1.next())
				{
					System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getInt(4)+"\t"+rs1.getFloat(5));

				}
				
				break;
			case 4:
				System.out.println("OPeration stopped on StudentDetails tables....!");
				System.exit(0);
				break;
			default:
				System.out.println("invalid choice ...!");
			}
		} //loop closed
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
