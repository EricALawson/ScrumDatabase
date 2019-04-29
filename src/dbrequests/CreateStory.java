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
		prepStmnt.setString(1, InputValidator.getUserStoryID());
		prepStmnt.setString(2, InputValidator.getProjectName());
		prepStmnt.setString(3, InputValidator.getRole());
		prepStmnt.setString(4, InputValidator.getGoal());
		prepStmnt.setString(5, InputValidator.getBenefit());
		prepStmnt.executeUpdate();
	}
	

}
