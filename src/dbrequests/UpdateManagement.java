package dbrequests;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import util.InputValidator;
public class UpdateManagement extends DatabaseRequest{
	
	public UpdateManagement() throws SQLException{
		description = "Update Management";
	}
	
	
	@Override
	public void execute() throws SQLException {
		String setColumn;
		String findColumn;
		System.out.println("Which column do you want to update?");
		setColumn = InputValidator.getManagementColumn();
		System.out.println("Which column do you want to set a condition under?");
		findColumn = InputValidator.getManagementColumn();
		
		String sql = "UPDATE ManagementMembers SET ManagementMembers." + setColumn + " = ? WHERE ManagementMembers." + findColumn + " = ?;";
		prepStmnt = conn.prepareStatement(sql);
		
		
		System.out.println("Enter the update value to set ManagementMembers." + setColumn + " = ?: ");
		if (setColumn == "ProjectName")
			prepStmnt.setString(1, InputValidator.getProjectName());
		else if (setColumn == "EmployeeID")
			prepStmnt.setString(1, InputValidator.getEmployeeID());
		
		System.out.println("Enter the condition value where ManagementMembers." + findColumn + " = ?: ");
		if (findColumn == "ProjectName")
			prepStmnt.setString(2, InputValidator.getProjectName());
		else if (findColumn == "EmployeeID")
			prepStmnt.setString(2, InputValidator.getEmployeeID());
				
		try {
			int rowsAffected = prepStmnt.executeUpdate();
			
	        if (rowsAffected > 0) {
	            System.out.println("Success: " + rowsAffected + " rows affected.");
	        } else if (rowsAffected == 0) {
	            System.out.println("Failure: " + rowsAffected + " rows affected.");
	        }
	        else {
	            System.out.println("Error: " + rowsAffected + " rows affected.");
	        }
		}
		catch (SQLIntegrityConstraintViolationException e){
			System.out.println("Error: Duplicate entry in table or ProjectName not in Projects table.");
			System.out.println(e);
		}
	}

}
