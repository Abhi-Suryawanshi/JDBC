package com.JDBCdemo;

import java.sql.*;
import java.util.Scanner;

public class Demo3 {
	static String url = "jdbc:mysql://localhost:3306/jdbc";
	static String uname = "root";
	static String pass = "root";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please choose operation: ");
		System.out.println("1.insert");
		System.out.println("2.display");
		System.out.println("3.update");
		System.out.println("4.delete");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: {
			insertData(sc);
			break;
		}
		case 2: {
			displayData(sc);
			break;
		}
		case 3: {
			updateData(sc);
			break;
		}
		case 4: {
			deleteData(sc);
			break;
		}
		default:
			System.out.println("Invalid choice");
		}
	}
	
	
	public static void insertData(Scanner sc) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, pass);
		System.out.println("Connection established: " + con);
	
		System.out.println("Enter roll to add: ");
		int roll = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name to add:");
		String name = sc.nextLine();
		
		String sql	= "INSERT INTO student VALUES(?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, roll);
		ps.setString(2, name);
		
		int r = ps.executeUpdate();
		System.out.println(r + " rows inserted");
	}
	
	public static void displayData(Scanner sc) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, pass);
		System.out.println("Connection established: " + con);
		
		String sql = "SELECT * FROM student";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery(sql);
		System.out.println("Data displayed: ");
		
		while (rs.next()) {
			System.out.print("Roll: " + rs.getInt(1));
			System.out.println(" Name: " + rs.getString(2));
		}
		
	}
	
	public static void updateData(Scanner sc) throws Exception {	
 		Connection con = DriverManager.getConnection(url, uname, pass);
		System.out.println("Connection established: " + con);
		
		System.out.println("Enter roll to change its name :");
		int roll = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new name: ");
		String name = sc.nextLine();
		
		String sql	= "update student set name =? where roll = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(2, roll);
		ps.setString(1, name);
		
		int r = ps.executeUpdate();
		System.out.println(r + " rows updated");
	}
	
	public static void deleteData(Scanner sc) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, pass);
		System.out.println("Connection established: " + con);
		
		System.out.println("Enter roll to delete:");
		int roll = sc.nextInt();
		sc.nextLine();
		
		String sql	= "delete from student where roll = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, roll);
		
		int r = ps.executeUpdate();
		System.out.println(r + " rows deleted");
	}

}
