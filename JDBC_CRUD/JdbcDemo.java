package com.JDBCdemo;

//step 1 - import sql package
import java.sql.*;

public class JdbcDemo {

	public static void main(String[] args) throws Exception {
		
		//step 2 - load driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//step 3 - establish connection
		String url = "jdbc:mysql://localhost:3306/jdbc_1";
		String uname = "root";
		String pass = "root";
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		
		System.out.println("Connection established: " + con);
	}

}
