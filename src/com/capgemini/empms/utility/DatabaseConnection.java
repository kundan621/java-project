package com.capgemini.empms.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection 
{
	private static Connection conn=null;
	
	public static Connection getConnection()		// static method of type Connection to call it from any class 
	{
		if(conn==null)	// for checking only 1 existing connection between class and database
		{
			Properties prop=new Properties();
			String url;
			String userName;
			String password;
			String driver;
						
			try
			{
				FileInputStream fis=new FileInputStream("./resources/jdbc.properties");
				prop.load(fis);
				url=prop.getProperty("url");
				userName=prop.getProperty("userName");
				password=prop.getProperty("password");
				driver=prop.getProperty("driver");
				Class.forName(driver);
				conn=DriverManager.getConnection(url,userName,password);
				System.out.println("\nPlease wait while we connect you with the system...!");
			}
			catch(FileNotFoundException fe)
			{
				fe.printStackTrace();
			}
			catch(IOException  ie)
			{
				ie.printStackTrace();
			}
			catch(ClassNotFoundException ce)
			{
				ce.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return conn;
	}
}