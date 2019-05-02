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
		prepStmnt.executeUpdate();
		
		System.out.println("New Sprint has been created");
		System.out.println("Project Name = " + ProjectName);
		System.out.println("Sprint ID = " + SprintID);
		System.out.println("Start Date = " + StartDate);
		System.out.println("End Date = " + EndDate);
		System.out.println("Status = " + Status);
		
		
	}

}
