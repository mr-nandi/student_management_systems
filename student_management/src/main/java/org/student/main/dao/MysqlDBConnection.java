package org.student.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MysqlDBConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = null;
	private static final String DB_PASSWORD = "islukutta";
	private static final String DB_USER = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Connection dbconnect() {
		
		Connection connection = null;
		
		try
		{
			connection =DriverManager.getConnection(DB_URL+DB_NAME,DB_USER, DB_PASSWORD);
		}
		catch(SQLException e)
		{
			System.out.println("Connection Error!!");
		}
		return connection;
	}

}

