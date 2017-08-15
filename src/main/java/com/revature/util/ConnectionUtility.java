package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.OracleDriver;

public class ConnectionUtility
{
	public static java.sql.Connection getConnectionFromProperties() throws IOException, SQLException
	{
//		Properties properties = new Properties();
//		
//		InputStream inputStream = PropInfo.class.getClassLoader().getResourceAsStream(new FileInputStream("connection.properties"));
//		
//		properties.load(inputStream);
		
		String url = "jdbc:oracle:thin:@protoreimbursment.ct8iyplsxvql.us-east-2.rds.amazonaws.com:1521:orcl";
		String username = "ERS_User";
		String password = "ERS_Password";
		
		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);


		return DriverManager.getConnection(url, username, password);
		
		
	}
}
