package Pack1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tranxmgmt {

	public static void main(String[] args) throws SQLException
	{
		// TODO Auto-generated method stub
		Connection c=null;
		int r1=0,r2=0,r3=0;
		try
		{
			c=Connectionu.getconnectionfromdb();
			c.setAutoCommit(false);
			Statement s=c.createStatement();
			r1=s.executeUpdate("insert into student values(101,'rahul',8)");
			r2=s.executeUpdate("insert into student values(102,'derik',9)");
			r3=s.executeUpdate("delete from student where id=2");
			c.commit();
		}
		catch(Exception e)
		{
			System.out.println(r1+"  "+r2+"   "+r3);
			try
			{
				c.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			c.close();
		}

	}

}
