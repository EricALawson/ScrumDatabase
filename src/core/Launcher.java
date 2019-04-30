package core; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dbrequests.DatabaseRequest;

public class Launcher {
	private static String dbURL1 = "jdbc:mysql://192.168.109.133:3306/testSCRUM?useSSL=false&serverTimezone=UTC";	
	private static String userName = "cecs323b";
	private static String password = "cecs323";
	private static Connection conn1 = null;
	private static Statement stmnt = null;

	public static void main(String[] args) {
		CreateConnection();
		DatabaseRequest.setConnection(conn1);
		
		DatabaseRequest.initializeRequests();
		
		SystemMenu.runMenu();
		
		ShutDown();
	}
	
	private static void printSQLException(SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
		ex.printStackTrace();
	}
	
	private static void CreateConnection() {
		try {
			conn1 = DriverManager.getConnection(dbURL1, userName, password);
			if (conn1 != null) {
				System.out.println("Connected to SecondDB");
			}
		} catch (SQLException ex) {
			printSQLException(ex);
		}
	}
	
	private static void ShutDown() {
		try {
			if (stmnt != null) {
				stmnt.close();
			}
			if (conn1 != null) {
				conn1.close();
				System.out.println("Connection Closed.");
			}
		} catch (SQLException ex) {
			printSQLException(ex);
		}
	}
}
