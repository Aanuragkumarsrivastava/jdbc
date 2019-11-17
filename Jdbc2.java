package Pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		
		Statement s= c.createStatement();
		
		ResultSet r=s.executeQuery("select * from student where id=5");
		while(r.next())
		{
			System.out.println(r.getString("id")+"  "+r.getString("name")+"  "+r.getString("marks"));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
