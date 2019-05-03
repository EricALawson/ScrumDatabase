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
		
		try{
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
