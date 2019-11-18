package Pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Preparedstdemo {

	public static void main(String[] args) throws SQLException 
	{
		Connection c=null;
		try
		{
			c=Connectionu.getconnectionfromdb();
			PreparedStatement p=c.prepareStatement("insert into student values(?,?,?)");
			@SuppressWarnings("resource")
			Scanner in=new Scanner(System.in);
			
			for(int i=1;i<=3;i++)
			{
				System.out.println("enter student data in follwing way : id,name,marks");
				int id=in.nextInt();
				String name=in.next();
				int marks=in.nextInt();
				
				p.setInt(1,id);
				p.setString(2,name);
				p.setInt(3,marks);
				
				int exe=p.executeUpdate();
				if(exe>0)
				{
					System.out.println("update succesfully");
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		finally
		{
			c.close();
		}

	}

}
