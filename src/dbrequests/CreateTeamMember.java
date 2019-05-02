package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateTeamMember extends DatabaseRequest {

	public CreateTeamMember() throws SQLException {
		description = "Create Team Member";
		String sql = "INSERT INTO SCRUMTeamMembers(TeamName, EmployeeID) VALUES (?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		String TeamName = InputValidator.getTeamName();
		String EmployeeID = InputValidator.getEmployeeID();
		prepStmnt.setString(1, TeamName);
		prepStmnt.setString(2, EmployeeID);
		prepStmnt.executeUpdate();
		
		System.out.println("New Team Member Created");
		System.out.println("Team Member Name: " + TeamName + "\tEmploye ID: " + EmployeeID);

	}
}
