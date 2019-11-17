package Pack1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc1 {

	public static void main(String[] args) 
	{
		try
		{
			//first of all load the driver
			Class.forName("oracle.jdbc.OracleDriver");
			
			//getting connection
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
			//create statement object
			 Statement s = c.createStatement();
			
			//execute query to get the access to the table
			//before this create table in the oracle database
			//also add an external jar ojdbc7 
			 ResultSet r = s.executeQuery("select * from student");
			 
			 //to print the data of table
			 while(r.next())
			 {
				System.out.println(r.getString("id")+"   "+r.getString("name")+"    "+r.getString("marks"));
				
			 }
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
