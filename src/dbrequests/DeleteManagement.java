package dbrequests;

import java.sql.SQLException;
import util.InputValidator;

public class DeleteManagement extends DatabaseRequest{
	
	public DeleteManagement() {
		description = "Remove Engineer from Project Management";
	}
	
	@Override
	public void execute() throws SQLException {
		String findColumn = InputValidator.getManagementColumn();
		String findCondition;
		if (findColumn = "ProjectName") {
			findCondition = InputValidator.getProjectName();
		}
		else if (findColumn = "EmployeeID") {
			findCondition = InputValidator.getEmployeeID();
		}
		String sql = "DELETE FROM ManagementMembers WHERE ManagementMembers." + findColumn + " = ?;";
		prepStmnt = conn.prepareStatement(sql);
		prepStmnt.setString(1, findCondition);
		
		int rows_affected = prepStmnt.executeUpdate();
		
		if (rows_affected > 0) {
			System.out.println("Success: " + rows_affected + " rows affected.");
		} else if (rows_affected == 0) {
			System.out.println("Failure: " + rows_affected + " rows affected.");
		}
		else {
			System.out.printlm("Error: " + rows_affected + " rows affected.");
		}
	}

}
