package org.student.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import org.student.main.dao.LoginOperations;

public class App 
{	static int studentid;
static String name;
static String address;
static int age;
static String course;
static int total_fees;
static int paid;
static int balance_amount;
static String user;
static String pass;

BufferedReader bufferreader = new BufferedReader (new InputStreamReader(System.in));
static Scanner scanner = new Scanner (System.in);

public static void main(String[] args) throws ClassNotFoundException, SQLException {

System.out.println("*******************************************************");
System.out.println("*********** STUDENT MANAGEMENT SYSTEMS ****************");
System.out.println("*******************************************************");

boolean status=false;
do
{
	System.out.println("*******************************************************");
	System.out.println("*******************************************************");
	System.out.println("\t \t Enter 1 -> Create an Account");
	System.out.println("\t \t Enter 2 -> LogIn an Account");
	System.out.println("*******************************************************");
	System.out.println("*******************************************************");
	System.out.println("\t\t Enter the valid Input: ");
	int choice = Integer.parseInt(scanner.next());
	
	switch (choice)
	{
	case 1: System.out.println("Enter Student Name:");
	String name = scanner.next();
	System.out.println("Enter Student Id");
	studentid = scanner.nextInt();		
	System.out.println("Enter Address");
	address = scanner.next();
	System.out.println("Enter Age");
	age = scanner.nextInt();
	System.out.println("Enter Course");
	course = scanner.next();
	System.out.println("Enter Username");
	user = scanner.next();
	System.out.println("Enter Password");
	pass = scanner.next();
	System.out.println("=======================================================");
	System.out.println("\t\t Student Name: " + name);
	System.out.println("\t\t Student ID: " + studentid);
	System.out.println("\t\t Student Address: " + address);
	System.out.println("\t\t Student Age: " + age);
	System.out.println("\t\t Student Course: " + course);
	System.out.println("\t\t Student Fees: " + name ); // mention here fees from the course table
	System.out.println("\t\t Student Username: " + user);
	System.out.println("\t\t Student Password: " + pass);
	System.out.println("=======================================================");
	
	break;
	
	case 2: 
	System.out.println("=======================================================");
	System.out.println("*******************************************************");
	System.out.print("\t\t  Username: ");// "\t " is used to tab move
	String username = new String();
	username= scanner.next();
	System.out.print("\t\t  Password: ");
	String pass = new String();
	pass =  scanner.next();
	System.out.println("*******************************************************");
	System.out.println("=======================================================");
	status= LoginOperations.login(username, pass);
	
	if (status) {
		do {
			System.out.println("=======================================================");
			System.out.println("*******************************************************");
			System.out.println("\t \t Enter 1 -> Check Data");
			System.out.println("\t \t Enter 2 -> Coursre and Fees Details");
			System.out.println("\t \t Enter 3 -> Students List");
			System.out.println("\t \t Enter 4 -> Logout");
			System.out.println("=======================================================");
			System.out.println("*******************************************************");
			System.out.println("\t\t Enter the valid Input: ");
			int choice1 = Integer.parseInt(scanner.next());
			
			switch(choice1) {
			
			case 1:
				System.out.println("=======================================================");
				System.out.println("Enter Student ID: ");
				studentid = scanner.nextInt();
				System.out.println("Details of Student Id: " + studentid);
				
				
				break;
				
			case 2:
				System.out.println("=======================================================");
				System.out.println("Availabe Courses And Fees Details");
				System.out.println("000000"); // show the fees table
				System.out.println("=======================================================");
				
				break;
				
			case 3:
				System.out.println("=======================================================");
				System.out.println("Students List");
				System.out.println("000000"); // Show the Students table
				System.out.println("=======================================================");
				
				break;
			case 4:
				status =  false;
				System.out.println("=======================================================");
				System.out.println("Successfully Logout");
				System.out.println("Thank You - All the Best !"); // 
				System.out.println("=======================================================");
				
				break;
				
			default : 
				System.out.println("=======================================================");
				System.out.println("\t\t X X X - Invalid Input - X X X ");
				System.out.println("=======================================================");
			}
		}
		while(status);
	}
	default : 
		System.out.println("=======================================================");
		System.out.println("\t\t x x x - Invalid Input - x x x ");
		System.out.println("=======================================================");
	}

}
while(status);	
}
}