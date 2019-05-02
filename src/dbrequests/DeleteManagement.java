package dbrequests;

import java.sql.SQLException;

public class DeleteManagement extends DatabaseRequest{

	public DeleteManagement() throws SQLException {
		description = "Delete a management member";
	}

	@Override
	public void execute() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
