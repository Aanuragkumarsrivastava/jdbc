package Pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connectionu {

	public static Connection getconnectionfromdb() 
	{
		// TODO Auto-generated method stub
		Connection c=null;
		try
		{
			BufferedReader b=new BufferedReader(new FileReader("C:\\Users\\lenovo\\Desktop\\spring\\jdbc\\src\\Pack1\\db.properties"));
			
			Properties p=new Properties();//creating obj. for property
			
			p.load(b);//loading the data of property file to obj.
			
			String url=p.getProperty("url");//getting url in variable url
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			c=DriverManager.getConnection(url,username,password);
	
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		return c;
	}

}
