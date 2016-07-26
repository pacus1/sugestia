package com.app.other.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDBS {

	//connection to local dbs
//	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/sugestiaDB?user=postgres&password=admin";
	
	//connection to Heroku dbs
	//private static final String DATABASE_URL = "jdbc:postgresql://ec2-54-228-219-2.eu-west-1.compute.amazonaws.com:5432/davlnk5ukati5r?sslmode=require&user=pxtvzlortfjhdh&password=QY9jN5mm1dMBMJqVGZ9RavILOe";

	// 
	private static final String DATABASE_URL = "jdbc:postgresql://ec2-54-75-238-7.eu-west-1.compute.amazonaws.com:5432/d7uspq8tpsf5g?sslmode=require&user=ruighabjkqpgan&password=P84k93A2Vvvu5pnXc31pHHoVPN";
	
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
