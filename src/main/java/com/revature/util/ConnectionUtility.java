package com.revature.util;

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
//		InputStream inputStream = new FileInputStream("connection.properties");
//		
//		properties.load(inputStream);
		
		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		
		
		String url ="jdbc:oracle:thin:@protoreimbursment.ct8iyplsxvql.us-east-2.rds.amazonaws.com:1521:orcl";
		String username = "ERS_User";
		String password = "ERS_Password";
		
		return DriverManager.getConnection(url, username, password);
		
		
	}
}
