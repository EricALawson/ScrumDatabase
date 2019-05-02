package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateStory extends DatabaseRequest {

	public CreateStory() throws SQLException {
		description = "Create Story";
		String sql = "INSERT INTO UserStories(USID, ProjectName, Role, Goal, Benefit) VALUES (?, ?, ?, ?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		
		String UserStoryID = InputValidator.getUserStoryID();
		String ProjectName = InputValidator.getProjectName();
		String Role = InputValidator.getRole();
		String Goal = InputValidator.getGoal();
		String Benefit = InputValidator.getBenefit();
		prepStmnt.setString(1, UserStoryID);
		prepStmnt.setString(2, ProjectName);
		prepStmnt.setString(3, Role);
		prepStmnt.setString(4, Goal);
		prepStmnt.setString(5, Benefit);
		prepStmnt.executeUpdate();
		
		System.out.println("New User Story Created");
		System.out.println("User Story ID: " + UserStoryID);
		System.out.println("Project Name: " + ProjectName);
		System.out.println("Role: " + Role);
		System.out.println("Goal: " + Goal);
		System.out.println("Benefit: " + Benefit);
	}
	

}
