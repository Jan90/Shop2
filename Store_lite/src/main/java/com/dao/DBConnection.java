package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	private static Connection connection = null;
	static InputStream inputStream;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {

			try {
				Properties properties = new Properties();
				inputStream = DBConnection.class.getClassLoader()
						.getResourceAsStream("db/data-access.properties");
				properties.load(inputStream);
				String driverClassName = properties
						.getProperty("driverClassName");
				String url = properties.getProperty("url");
				String user = properties.getProperty("username");
				String password = properties.getProperty("password");
				Class.forName(driverClassName);
				connection = DriverManager.getConnection(url, user, password);
				inputStream = DBConnection.class.getClassLoader()
						.getResourceAsStream("db/dbScriptlet.sql");
				java.util.Scanner scanner = new java.util.Scanner(inputStream,
						"UTF-8").useDelimiter("\\A");
				String theString = scanner.hasNext() ? scanner.next() : "";
				Statement st = connection.createStatement();
				st.execute(theString);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return connection;
		}
	}
}
