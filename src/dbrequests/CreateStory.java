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
		
		try {
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
		catch (SQLIntegrityConstraintViolationException e){
			System.out.println("Error: ");
			System.out.println(e);
		}
	}
	

}
