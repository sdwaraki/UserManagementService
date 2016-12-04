package com.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	
	private static Connection connection = null;
	
	public Connection getConnection() {
		try {
			Properties dbProperties = new Properties();
			dbProperties.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
			String dbUrl = dbProperties.getProperty("dburl");
			String userName = dbProperties.getProperty("user");
			String password = dbProperties.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl,userName,password);
			return connection;
		}
		catch (Exception e) {
			System.out.println("The connection URL is incorrect");
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
