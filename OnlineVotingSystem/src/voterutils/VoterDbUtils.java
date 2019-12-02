package voterutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;	

public class VoterDbUtils {
	private static Connection conn;
	
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		if(conn==null) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava","root","tiger");
		}
		return conn;
	}
	
	public static void nullifyConnection() {
		conn=null;
	}

}
