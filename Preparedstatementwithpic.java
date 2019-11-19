package Pack1;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Preparedstatementwithpic {

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception
	{
		Connection c=null;
		try 
		{
			c=Connectionu.getconnectionfromdb();
			PreparedStatement p=c.prepareStatement("insert into student values(?,?,?,?)");
			Scanner in=new Scanner(System.in);
			p.setInt(1,in.nextInt());
			p.setString(2,in.next());		
			p.setInt(3,in.nextInt());
	        System.out.println("enter the image path\n");
	        String imgpath=in.next();
	        File file=new File(imgpath);
	        FileInputStream filestream=new FileInputStream(file);
	        long length=file.length();
	        p.setBlob(4,filestream,length);
	        int update1=p.executeUpdate();
	        if(update1>0)
	        {
	        	System.out.println("updated successfully!!!!!");
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
