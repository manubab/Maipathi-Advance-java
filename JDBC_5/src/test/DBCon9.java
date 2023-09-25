package test;
import java.sql.*;
import java.util.*;
public class DBCon9 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			
			try
			{
				System.out.println("================ Enter the emp Details =============");
				
				System.out.println("Enter the empId");
				String eid=sc.nextLine();
				System.out.println("Enter the empName");
				String eName=sc.nextLine();
				System.out.println("Enter the empDesg");
				String edesg=sc.nextLine();
				System.out.println("Enter the hNo");
				String hNo=sc.nextLine();
				System.out.println("Enter the StreatName");
				String sName=sc.nextLine();
				System.out.println("Enter the City");
				String cty=sc.nextLine();
				System.out.println("Enter the pcode");
				int pcode=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the empMailId");
				String mid=sc.nextLine();
				System.out.println("Enter the empPhoneNumber");
				long pno=Long.parseLong(sc.nextLine());
				System.out.println("Enter the bSal");
				float bSal=Float.parseFloat(sc.nextLine());
				System.out.println("Enter the hra");
				int hra=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the da");
				int da=Integer.parseInt(sc.nextLine());
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
				CallableStatement cs=con.prepareCall		
				("{call EmpInsert52(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cs.setString(1, eid);
				cs.setString(2,eName );
				cs.setString(3, edesg);
				cs.setString(4,hNo);
				cs.setString(5,sName);
				cs.setString(6,cty);
				cs.setInt(7,pcode);
				cs.setString(8, mid);
				cs.setLong(9, pno);
				cs.setFloat(10, bSal);
				cs.setFloat(11,hra);
				cs.setFloat(12, da);
				cs.setFloat(13, bSal+(0.93f*bSal)+(0.63f* bSal)+hra+da);
				cs.execute();
				System.out.println("Procedure execeted Successfully ....");
				System.out.println(" Emp Data Updated ....");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}

}
