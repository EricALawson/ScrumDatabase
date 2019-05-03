package dbrequests;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import util.InputValidator;

public class CreateTeamMember extends DatabaseRequest {

	public CreateTeamMember() throws SQLException {
		description = "Create Team Member";
		String sql = "INSERT INTO SCRUMTeamMembers(TeamName, EmployeeID) VALUES (?, ?);";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		String TeamName = InputValidator.getTeamName();
		String EmployeeID = InputValidator.getEmployeeID();
		try {
			prepStmnt.setString(1, TeamName);
			prepStmnt.setString(2, EmployeeID);
			
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
			System.out.println("Error: Duplicate entry or TeamName is not in SCRUMTeams table or EmployeeID is not in SoftwareEngineers table.");
			System.out.println(e);
		}
	}
}
