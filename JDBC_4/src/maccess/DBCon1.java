package maccess;

public class DBCon1 {
	public static void main(String[] args) {
		
		CPolling cp=new CPolling
  ("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger");
		
		cp.createConnections();
	}

}
