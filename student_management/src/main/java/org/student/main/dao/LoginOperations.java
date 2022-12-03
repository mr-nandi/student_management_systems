package org.student.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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


	Connection conc = null;
	Statement state = null;
	
	
	public static int save(String name, int studentid, String address, int age, String course, int total_fees, String user,
			String pass) throws SQLException {
		int name1=Integer.parseInt(name);
		int address1 = Integer.parseInt(address);
		int course1 =  Integer.parseInt(course);
		int user1= Integer.parseInt(user);
		int pass1 = Integer.parseInt(pass);
		Connection conn = null;
		Statement statem = conn.createStatement();           
		
		String sql = "INSERT INTO studentlist values("+name1+","+studentid+","+address1+","+age+","+course1+","+total_fees+","+user1+","+pass1+")";    
		statem.executeUpdate(sql);
		System.out.println("Successfully Saved");

		return 0;
	}

	public static boolean coursefees() {
	
		try {
			Connection connection = MysqlDBConnection.dbconnect();
			String query= "Select * from course_fees";
			Statement statement = connection.createStatement();
			ResultSet resultset= statement.executeQuery(query);
			
			while(resultset.next()) {
				String Course = resultset.getString("Course");
				int Fees = resultset.getInt("Fees");

				System.out.format("\t"+"%s, %s, %s\n",Course,Fees);
			
		
		}}
		catch (SQLException e)
		{
		
		}
		return false;
		
	
	}

	public static boolean stdet() throws SQLException {
		
			Connection connection = MysqlDBConnection.dbconnect();
			String query= "select * from studentlist where Student_ID=";
			Statement statement = connection.createStatement();
			ResultSet resultset= statement.executeQuery(query);
			
			while (resultset.next()) {
				int id = resultset.getInt("Student_ID");
				String name =  resultset.getString("Student_Name");
				String address =  resultset.getString("Address");
				int age = resultset.getInt("Age");
				String course =  resultset.getString("Course");
				int fees = resultset.getInt("Fees");
				String user =  resultset.getString("Username");
				String pass =  resultset.getString("Password");
				
				System.out.format("\t"+"%s, %s, %s,%s, %s, %s,%s, %s\n", id, name,address, age, course, fees, user, pass );
			}
			
			return false;
		
			
		}
}