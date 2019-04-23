package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateProject extends DatabaseRequest {
	
	public CreateProject() throws SQLException {
		description = "Create Project";
		String sql = "INSERT INTO Projects(?,?,?);";
		prepStmnt = conn.prepareStatement(sql);
	}

	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getProjectName());
		prepStmnt.setString(2, InputValidator.getStartDate());
		prepStmnt.setString(3, InputValidator.getEndDate());
	}
}
