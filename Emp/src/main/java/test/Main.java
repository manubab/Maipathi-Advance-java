package test;
import java.util.Scanner;
public class Main 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try {
		while(true)
		{
			System.out.println("---------- Choice -----------"
					+ "\n\t1.insertData"
					+ "\n\t2.readData"
					+ "\n\t3.updateData"
					+ "\n\t4.deleteData"
					+ "\n\t5.exitApp"
					+ "\n Enter the choice :");
			
			switch(Integer.parseInt(sc.nextLine()))
			{
			case 1:
				System.out.println("Enter the eId :");
				String eId=sc.nextLine();
				System.out.println("Enter the eName");
				String eName=sc.nextLine();
				System.out.println("Enter the eDesg");
				String eDesg=sc.nextLine();
				System.out.println("Enter the eSal");
				double eSal=Double.parseDouble(sc.nextLine());
				
				Employee e=new Employee();
				e.seteId(eId);
				e.seteName(eName);
				e.seteDesg(eDesg);
				e.seteSal(eSal);
				int k=new EmployeeCurdDAO().insertData(e);
				System.out.println("Data inserted Successfully....!");
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("Application execution completed.....!");
				System.exit(1);
				break;
				default:
					System.out.println("invalid choice  Enter only 1-5 values....!");
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("Enter only Integer Data.....!");
		}
		
		
	}

}
