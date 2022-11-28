package org.student.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean login(String username, String pass)throws ClassNotFoundException, SQLException
	{
		
		try {
			Connection connection = MysqlDBConnection.dbconnect();
			PreparedStatement statement = connection.prepareStatement("select * from account where username=?");
			statement.setString(1, username);
			ResultSet result=statement.executeQuery();
			if(result.next())
			{
				
				if (result.getString("password").equals(pass))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			System.out.println("Username is incorrect!!");
		}
		
		
		
		
		return false;
	}

}
