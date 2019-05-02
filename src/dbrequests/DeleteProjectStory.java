package dbrequests;

import java.sql.SQLException;

public class DeleteProjectStory extends DatabaseRequest{

	public DeleteProjectStory() throws SQLException {
		description = "Delete story from project";
	}

	@Override
	public void execute() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
