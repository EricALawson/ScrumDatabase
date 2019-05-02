package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateSprintMember extends DatabaseRequest{
	
	public CreateSprintMember() throws SQLException {
		description = "Create Sprint Member";
		String updateSQL = "INSERT INTO SprintTeamMembers  (TeamName,SprintID,EmployeeID) VALUES(?,?,?)";
		prepStmnt = conn.prepareStatement(updateSQL);
		
		
	}

	@Override
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getTeamName());
		prepStmnt.setString(2, InputValidator.getSprintID());
		prepStmnt.setString(3, InputValidator.getEmployeeID());
		prepStmnt.executeUpdate();
		
	}

}
