package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateSprint extends DatabaseRequest {

	public CreateSprint() throws SQLException {
		description = "Create Sprint";
		String sql = "INSERT INTO Sprints VALUES(?, ?, ?, ?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		String ProjectName = InputValidator.getProjectName();
		String SprintID = InputValidator.getSprintID();
		String StartDate = InputValidator.getStartDate();
		String EndDate = InputValidator.getEndDate();
		String Status = InputValidator.getStatus();
		prepStmnt.setString(1, ProjectName);
		prepStmnt.setString(2, SprintID);
		prepStmnt.setString(3, StartDate);
		prepStmnt.setString(4, EndDate);
		prepStmnt.setString(5, Status);
		
		int rows_affected = prepStmnt.executeUpdate();

		if (rows_affected > 0) {
		    System.out.println("Success: " + rows_affected + " rows affected.");
		} else if (rows_affected == 0) {
		    System.out.println("Failure: " + rows_affected + " rows affected.");
		}
		else {
		    System.out.println("Error: " + rows_affected + " rows affected.");
		}
		
		
	}

}
