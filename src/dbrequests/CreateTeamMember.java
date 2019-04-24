package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateTeamMember extends DatabaseRequest {

	public CreateTeamMember() throws SQLException {
		description = "Create Team Member";
		String sql = "INSERT INTO SCRUMTeamMembers(?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getTeamName());
		prepStmnt.setString(2, InputValidator.getEmployeeID());
		prepStmnt.executeUpdate();
	}
}
