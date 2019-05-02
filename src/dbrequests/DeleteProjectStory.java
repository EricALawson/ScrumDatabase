package dbrequests;

import util.InputValidator;

import java.sql.SQLException;

public class DeleteProjectStory extends DatabaseRequest{

	public DeleteProjectStory() throws SQLException {
		description = "Delete story from project";
		String sql = "DELETE FROM UserStories WHERE UserStories.USID = ?";
		prepStmnt = conn.prepareStatement(sql);
	}

	@Override
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getUserStoryID());
		int deleted = prepStmnt.executeUpdate();
		if (deleted > 0) {
			System.out.println(deleted + " user story was deleted");
		} else {
			System.out.println("Failure: No matching user story found");
		}
	}

}
