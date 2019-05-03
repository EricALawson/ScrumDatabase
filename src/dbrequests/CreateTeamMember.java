package dbrequests;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
		try {
			prepStmnt.setString(1, TeamName);
			prepStmnt.setString(2, EmployeeID);
			prepStmnt.executeUpdate();
			
			System.out.println("New Team Member Created");
			System.out.println("Team Member Name: " + TeamName + "\tEmployee ID: " + EmployeeID);
		}
		catch (SQLIntegrityConstraintViolationException e){
			System.out.println("Error: Duplicate entry or TeamName is not in SCRUMTeams table or EmployeeID is not in SoftwareEngineers table.");
			System.out.println(e);
		}
	}
}
