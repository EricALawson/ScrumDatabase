package dbrequests;

import util.InputValidator;

import java.sql.SQLException;

public class DeleteManagement extends DatabaseRequest{

	public DeleteManagement() throws SQLException {
		description = "Delete a management member";
		String sql = "DELETE FROM ManagementMembers WHERE ManagementMembers.EmployeeID = ?;";
		prepStmnt = conn.prepareStatement(sql);
	}

	@Override
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getEmployeeID());
		int deleted = prepStmnt.executeUpdate();
		if (deleted > 0) {
			System.out.println(deleted + "management member was deleted");
		} else {
			System.out.println("Failure: No matching management member found");
		}
		
	}

}
