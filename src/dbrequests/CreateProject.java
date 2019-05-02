package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateProject extends DatabaseRequest {
	
	public CreateProject() throws SQLException {
		description = "Create Project";
		String sql = "INSERT INTO Projects(ProjectName, StartDate, Endate) VALUES (?,?,?);";
		prepStmnt = conn.prepareStatement(sql);
	}

	public void execute() throws SQLException {
		String ProjectName = InputValidator.getProjectName();
		String StartDate = InputValidator.getStartDate();
		String EndDate = InputValidator.getEndDate();
		prepStmnt.setString(1, ProjectName);
		prepStmnt.setString(2, StartDate);
		prepStmnt.setString(3, EndDate);
		prepStmnt.executeUpdate();
		
		System.out.println("New  Project Has Been Created");
		System.out.println("Project Name = " + ProjectName);
		System.out.println("Start Date = " + StartDate);
		System.out.println("End Date = " + EndDate);
	}
}
