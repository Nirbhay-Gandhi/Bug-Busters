package com.bug.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public Connection getConnection()
	{
		try
		{
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  //step 2: get jdbc connection
	       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2?useSSL=false",
				"root","namrata");
	       
	       if(con!=null)
	       {
	    	   System.out.println("connection successful");
	       }
	       else
	       {
	    	   System.out.println("connection not successful"); 
	       }
	       
	       return con;
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	    
		return null;
		   
	}
	
	public void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try
			{
			  con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	

}
