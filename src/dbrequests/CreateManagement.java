package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateManagement extends DatabaseRequest {

	public CreateManagement() throws SQLException {
		description = "Create Management";
		String sql = "INSERT INTO ManagementMembers(?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getProjectName());
		prepStmnt.setString(2, InputValidator.getEmployeeID());
		prepStmnt.executeUpdate();
	}

}
