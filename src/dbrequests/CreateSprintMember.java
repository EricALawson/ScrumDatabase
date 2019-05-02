package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

import java.sql.ResultSet;

public class CreateSprintMember extends DatabaseRequest{
	
	public CreateSprintMember() throws SQLException {
		description = "Create Sprint Member";
		String updateSQL = "INSERT INTO SprintTeamMembers  (TeamName,SprintID,EmployeeID) VALUES(?,?,?)";
		prepStmnt = conn.prepareStatement(updateSQL);
		
		
	}

	@Override
	public void execute() throws SQLException {
		
		//InputValidator.
		
		String TeamName = InputValidator.getTeamName();
		String SprintID = InputValidator.getSprintID();
		String EmployeeID = InputValidator.getEmployeeID();
		prepStmnt.setString(1, TeamName);
		prepStmnt.setString(2, SprintID);
		prepStmnt.setString(3, EmployeeID);
		prepStmnt.executeQuery();
		
		String updateSQL = "SELECT * FROM SprintTeamMembers";
		
	
		/*prints user input*/
		System.out.println("Sprint Member Created");
		System.out.println("Team Name: " + TeamName + "\tEmployeeID: " + EmployeeID + "\tSprintID: " + SprintID);
		
		
		
	}

}
