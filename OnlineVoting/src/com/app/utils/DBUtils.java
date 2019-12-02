package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/testjava";
		return DriverManager.getConnection(url,"admin","tiger");
	}
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Connection c=fetchConnection();
//	}
}
