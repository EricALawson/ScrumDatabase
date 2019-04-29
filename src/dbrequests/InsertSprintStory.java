package dbrequests;

import java.sql.SQLException;
import util.InputValidator;

public class InsertSprintStory extends DatabaseRequest {
	public InsertSprintStory() throws SQLException{
		description = "Insert Sprint Backlog Story";
		String sql = "INSERT INTO SprintStories(USID, SprintID) VALUES (?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}

	@Override
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getUserStoryID());
		prepStmnt.setString(2, InputValidator.getSprintID());
	}
}
