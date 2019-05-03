package dbrequests;

import java.sql.SQLException;
import java.sql.ResultSet;

import util.InputValidator;

public class CreateManagement extends DatabaseRequest {

	public CreateManagement() throws SQLException {
		description = "Create Management";
		String sql = "INSERT INTO ManagementMembers(ProjectName, EmployeeID) VALUES (?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
			prepStmnt.setString(1, InputValidator.getProjectName());
			prepStmnt.setString(2, InputValidator.getEmployeeID());
		try {
			int updated = prepStmnt.executeUpdate();
			if (updated > 0) {
				System.out.println(updated + " rows were created.");
			}
		}
		catch (SQLIntegrityConstraintViolationException e){
			System.out.println("Error: ");
			System.out.println(e);
		}
	}

}
