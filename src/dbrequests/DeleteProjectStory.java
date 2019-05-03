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

	int removed = prepStmnt.executeUpdate();

	if (removed > 0) {
		System.out.println("Success: " + removed + " rows deleted");
	} else {
		System.out.println("Now matching team members were found.");
	}
	}

}
