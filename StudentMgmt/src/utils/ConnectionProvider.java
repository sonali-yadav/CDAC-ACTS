package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	//CREATING A CONNECTION DATA MEMBER
	private static Connection conn;
	
	//CREATE A STATIC MEMBER FUNCTION TO RETURN THE SINGLETON CONNECTION OBJECT
	//UTILS USUALLY HAVE STATIC FUNCTIONS
	//EXAMPLE OF SINGLETON PATTERN
	
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		if (conn==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava","admin","tiger");
		}
		return conn;
	}
}
