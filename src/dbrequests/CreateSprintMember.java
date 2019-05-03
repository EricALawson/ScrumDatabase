package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

import java.sql.ResultSet;

public class CreateSprintMember extends DatabaseRequest{
	
	public CreateSprintMember() throws SQLException {
		description = "Create Sprint Member";
		String updateSQL = "INSERT INTO SprintTeamMembers(TeamName,SprintID,EmployeeID) VALUES(?,?,?)";
		prepStmnt = conn.prepareStatement(updateSQL);
		
		
	}

	@Override
	public void execute() throws SQLException {
		
		//InputValidator.
		
		String TeamName = InputValidator.getTeamName();
		String SprintID = InputValidator.getSprintID();
		String EmployeeID = InputValidator.getEmployeeID();
		prepStmnt.setString(1, TeamName);
		prepStmnt.setString(2, SprintID);
		prepStmnt.setString(3, EmployeeID);
	
		try {
			/*prints user input*/
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
			System.out.println("Error: Duplicate Entry or TeamName/EmployeeID not in SCRUMTeamMembers");
			System.out.println(e);
		}
		
		
	}

}
