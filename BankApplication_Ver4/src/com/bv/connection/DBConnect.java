package com.bv.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {

	public static Connection getConnection()
	{
		Connection connection=null;
		//step1:create properties class object
		try
		{
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\Connection.properties");
		Properties properties=new Properties();
		//step 2:load properties file
		
		properties.load(fis);
		//get the data from properties file using key
		
		String driverClass=(String) properties.get("driverclass");
		String url=(String) properties.get("url");
		String username=(String) properties.get("username");
		String password=(String) properties.get("password");
		
		Class.forName(driverClass);
		System.out.println("Driver Found");
		connection=DriverManager.getConnection(url,username,password);
		System.out.println("Connection established:");
		}
		
	catch(IOException | SQLException | ClassNotFoundException e)
	{
		System.out.println(e);
	}
	
		
		
		return connection;
}
}
