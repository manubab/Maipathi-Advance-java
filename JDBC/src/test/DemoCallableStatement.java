package test;

import java.sql.*;
import java.util.*; // execute procedures and functions

public class DemoCallableStatement {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the accNo:");
			long accNo = Long.parseLong(sc.nextLine());
			System.out.println("Enter the CusId:");
			int cId = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the CusName:");
			String cName = sc.nextLine();
			System.out.println("Enter the Balence:");
			float bal = Float.parseFloat(sc.nextLine());
			System.out.println("Enter the accType:");
			String acType = sc.nextLine();

			// address

			System.out.println("Enter the HNO:");
			String hNo = sc.nextLine();
			System.out.println("Enter the StreatName:");
			String sN = sc.nextLine();
			System.out.println("Enter cityName:");
			String city = sc.nextLine();
			System.out.println("Enter the StateName:");
			String state = sc.nextLine();
			System.out.println("Enter the pincode:");
			int pinCode = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the mailId");
			String mId = sc.nextLine();
			System.out.println("Enter the phno:");
			long phNo = Long.parseLong(sc.nextLine());

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger");

			CallableStatement cs = con.prepareCall("{ call Register50(?,?,?,?,?,?,?,?,?,?,?,?)}");

			cs.setLong(1, accNo);
			cs.setInt(2, cId);
			cs.setString(3, cName);
			cs.setFloat(4, bal);
			cs.setString(5, acType);

			cs.setString(6, hNo);
			cs.setString(7, sN);
			cs.setString(8, city);
			cs.setString(9, state);
			cs.setInt(10, pinCode);
			cs.setString(11, mId);
			cs.setLong(12, phNo);

			cs.execute();

			System.out.println("Customer Registered....!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
