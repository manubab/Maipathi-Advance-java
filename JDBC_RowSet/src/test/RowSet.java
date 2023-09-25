package test;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.rowset.*;

public class RowSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				RowSetFactory rsf = RowSetProvider.newFactory();

				System.out.println("==== Choice ====");
				System.out.println("\t1.JDBC RowSet" + "\n\t2.Cached RowSet" + "\n\n\tEnter the choice :");
				switch (sc.nextInt()) {
				case 1:
					JdbcRowSet jrs = rsf.createJdbcRowSet();

					jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
					jrs.setUsername("System");
					jrs.setPassword("tiger");
					jrs.setCommand("select * from translogtab52");
					jrs.execute();
					
					jrs.afterLast();
					
					while (jrs.previous()) {
						System.out.println(
								jrs.getLong(1) + "\t" + jrs.getLong(2) + "\t" + jrs.getFloat(3) + jrs.getString(4));

					}
					break;
				case 2:
					
					CachedRowSet crs=rsf.createCachedRowSet();
					
					crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
					crs.setUsername("System");
					crs.setPassword("tiger");
					
					Date d=new Date();
					
					crs.setCommand("insert into translogTab52 values('"+3333+"','"+4444+"','"+2000+"','"+d.toString()+"')");
					crs.execute();
					
				System.out.println("data inserted successfully....");
					
					
					break;
				default:
					System.out.println("invalid choice .....!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
