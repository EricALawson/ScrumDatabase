package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateSprint extends DatabaseRequest {

	public CreateSprint() throws SQLException {
		description = "Create Sprint";
		String sql = "INSERT INTO Sprints(?, ?, ?, ?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getProjectName());
		prepStmnt.setString(2, InputValidator.getSprintID());
		prepStmnt.setString(3, InputValidator.getStartDate());
		prepStmnt.setString(4, InputValidator.getEndDate());
		prepStmnt.setString(5, InputValidator.getStatus());
		prepStmnt.executeUpdate();
	}

}
