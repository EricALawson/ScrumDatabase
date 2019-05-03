package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class CreateProject extends DatabaseRequest {
	
	public CreateProject() throws SQLException {
		description = "Create Project";
		String sql = "INSERT INTO Projects(ProjectName, StartDate, Endate) VALUES (?,?,?);";
		prepStmnt = conn.prepareStatement(sql);
	}

	public void execute() throws SQLException {
		String ProjectName = InputValidator.getProjectName();
		String StartDate = InputValidator.getStartDate();
		String EndDate = InputValidator.getEndDate();
		
		try{
			prepStmnt.setString(1, ProjectName);
			prepStmnt.setString(2, StartDate);
			prepStmnt.setString(3, EndDate);
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
