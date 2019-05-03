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
