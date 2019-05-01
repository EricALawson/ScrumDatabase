package dbrequests;

import java.sql.SQLException;

import java.sql.ResultSet;

public class ReadAllEngineers extends DatabaseRequest {

	public ReadAllEngineers() throws SQLException {
		String sql = "SELECT * FROM SoftwareEngineers";
		stmnt = conn.createStatement();
		resultSet = stmnt.executeQuery(sql);
	}
	
	public static void list() throws SQLException {
		
		System.out.println("TeamName\tEmployeeID\tSprintID");
		while(resultSet.next()) {
			String TeamName = resultSet.getString(1);
			String EmployeeID = resultSet.getString(2);
			String SprintID = resultSet.getString(3);
		
			System.out.println(TeamName + "\t" + EmployeeID + "\t" + SprintID);
		}
	}


	public void execute() throws SQLException {
		list();
	}
