package Pack1;
import java.sql.*;
import java.util.Scanner;

public class Reasuttable {

	public static void main(String[] args) throws SQLException{
		// TO0DO Auto-generated method stub
		Connection c=null;
		try
		{
			
		//part 1 to call the table
			
			c=Connectionu.getconnectionfromdb();
			Statement s=c.createStatement();
			@SuppressWarnings("resource")
			Scanner in=new Scanner(System.in);
			System.out.println("enter the table name \n");
			String t=in.next();
			ResultSet rs=s.executeQuery("select * from "+t);
			
			//resultsetmetadata part 2
			//take metadata from table
			ResultSetMetaData rsmd=rs.getMetaData();
			
			
			
			//getting the column names in order
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				System.out.println(rsmd.getColumnName(i)+"\t");	
			}
			System.out.println();// one line space
			
			//lets get column data
			while(rs.next())
			{
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					String ColumnType=rsmd.getColumnTypeName(i);
					if(ColumnType.equalsIgnoreCase("number"))
						System.out.println(rs.getLong(i));
					else if(ColumnType.equalsIgnoreCase("varchar")||ColumnType.equalsIgnoreCase("varchar2"))
						System.out.println(rs.getString(i));
				}
				System.out.println();
						
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
