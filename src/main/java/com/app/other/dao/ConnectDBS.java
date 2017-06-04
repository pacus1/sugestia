package com.app.other.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDBS {

	//connection to local dbs
	//private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/sugestiaDB?user=postgres&password=admin";
	
	//connection to Heroku dbs
	private static final String DATABASE_URL = "jdbc:postgresql://ec2-23-21-235-142.compute-1.amazonaws.com:5432/d7m1ps4lh63rr2?sslmode=require&user=nmiszbnpsaklwg&password=29404ab99aac6cb4b9401307a44f16886f67f7aedc84a12dd8c3af1f53afb6d0";
	
	static Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public static Connection connectDatabase() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DATABASE_URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Connection succesful");
		return connection;
	}
	
	
}
