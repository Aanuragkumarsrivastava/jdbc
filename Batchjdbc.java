package Pack1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Batchjdbc {

	public static void main(String[] args) throws SQLException
	{
		Connection c=null;
		int[] exebatch=null;
		try
		{
			c=Connectionu.getconnectionfromdb();
			Statement s=c.createStatement();
			//here the many sql query will be run in a batch in sequence 
			//here we are using the array for the sequence of execution of the queries
			s.addBatch("delete from student where id=3");
		    //use non select operations
			s.addBatch("delete from student where id=100");
			exebatch=s.executeBatch();
			for(int i=0;i<exebatch.length-1;i++)
			{
				System.out.println(exebatch[i]);
			}	

		}
		catch(Exception e)
		{
			for(int i=0;i<exebatch.length-1;i++)
			{
				System.out.println(exebatch[i]);
			}		
			e.printStackTrace();
			
		}
		finally
		{
			c.close();
		}

	}

}
