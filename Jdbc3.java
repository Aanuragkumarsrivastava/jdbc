package Pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int id=in.nextInt();
		String name=in.next();
		int marks =in .nextInt();
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		
		Statement s=c.createStatement();
		
		ResultSet r=s.executeQuery("insert into student values("+id+",'"+name+"',"+marks+")");
		while(r.next())
		{
			//after executing just check the table it will add those data in the table
			System.out.println(r.getString("id")+" "+r.getString("name")+"  "+r.getString("marks"));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
