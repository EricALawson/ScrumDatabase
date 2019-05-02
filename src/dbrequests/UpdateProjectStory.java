package dbrequests;

import java.sql.SQLException;
import java.util.Scanner;

import util.InputValidator;

public class UpdateProjectStory extends DatabaseRequest{

	
	public UpdateProjectStory() throws SQLException{
		description = "Update Project Story";
	}
	
	@Override
	public void execute() throws SQLException {
		String setColumn;
		String findColumn;
		System.out.println("Which column do you want to update?");
		setColumn = InputValidator.getProjectStoryColumn();
		System.out.println("Which column do you want to set a condition under?");
		findColumn = InputValidator.getProjectStoryColumn();

		String sql = "UPDATE UserStories INNER JOIN SprintStories ON UserStories.USID = SprintStories.USID SET UserStories."
		+ setColumn + " = ? WHERE SprintStories.SprintID IS NOT NULL AND UserStories." + findColumn + " = ?;";
		prepStmnt = conn.prepareStatement(sql);
		
		System.out.println("Enter the update value to set UserStories." + setColumn + " = ?:");
		if (setColumn == "USID")
			prepStmnt.setString(1, InputValidator.getUserStoryID());
		else if (setColumn == "ProjectName")
			prepStmnt.setString(1, InputValidator.getProjectName());
		else if (setColumn == "Role")
			prepStmnt.setString(1, InputValidator.getRole());
		else if (setColumn == "Goal")
			prepStmnt.setString(1, InputValidator.getGoal());
		else if (setColumn == "Benefit")
			prepStmnt.setString(1, InputValidator.getBenefit());
		
		System.out.println("Enter the condition value where UserStories." + findColumn + " = ?:");
		if (findColumn == "USID")
			prepStmnt.setString(2, InputValidator.getUserStoryID());
		else if (findColumn == "ProjectName")
			prepStmnt.setString(2, InputValidator.getProjectName());
		else if (findColumn == "Role")
			prepStmnt.setString(2, InputValidator.getRole());
		else if (findColumn == "Goal")
			prepStmnt.setString(2, InputValidator.getGoal());
		else if (findColumn == "Benefit")
			prepStmnt.setString(2, InputValidator.getBenefit());
		

		int rowsAffected = prepStmnt.executeUpdate();
		
		if (rowsAffected > 0) {
			System.out.println("Success: " + rowsAffected + " rows affected.");
		} 
		else if (rowsAffected == 0) {
			System.out.println("Failure: " + rowsAffected + " rows affected.");
		}
		else {
			System.out.println("Error: " + rowsAffected + " rows affected.");
		}
	}
	
}
