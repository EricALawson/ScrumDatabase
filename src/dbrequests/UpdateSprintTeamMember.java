package dbrequests;

import java.sql.SQLException;
import java.util.Scanner;

import util.InputValidator;

public class UpdateSprintTeamMember extends DatabaseRequest{
	
	public UpdateSprintTeamMember() throws SQLException{
		description = "Update Sprint Team Member";
	}
	
	@Override
	public void execute() throws SQLException {
		String setColumn, findColumn;
		
		System.out.println("Which column do you want to update?");
		setColumn = InputValidator.getSprintTeamMemberColumn();
		System.out.println("Which column do you want to set a condition under?");
		findColumn = InputValidator.getSprintTeamMemberColumn();
		
		
		String sql = "UPDATE SprintTeamMembers SET SprintTeamMembers." + setColumn + " = ? WHERE SprintTeamMembers." + findColumn + " = ?;";
		prepStmnt = conn.prepareStatement(sql);
		
		System.out.println("Enter the update value to set SprintTeamMembers." + setColumn + " = ?:");
		if (setColumn == "TeamName")
			prepStmnt.setString(1, InputValidator.getProjectName());
		else if (setColumn == "EmployeeID")
			prepStmnt.setString(1, InputValidator.getEmployeeID());
		else if (setColumn == "SprintID")
			prepStmnt.setString(1, InputValidator.getSprintID());
		
		System.out.println("Enter the condition value where SprintTeamMembers." + findColumn + " = ?:");
		if (findColumn == "TeamName")
			prepStmnt.setString(2, InputValidator.getProjectName());
		else if (findColumn == "EmployeeID")
			prepStmnt.setString(2, InputValidator.getEmployeeID());
		else if (findColumn == "SprintID")
			prepStmnt.setString(2, InputValidator.getSprintID());
		
		int rowsAffected = prepStmnt.executeUpdate();
		
		if (rowsAffected > 0) {
			System.out.println("Success: " + rowsAffected + " rows affected.");
		} 
		else if (rowsAffected == 0) {
			System.out.println("Failure: " + rowsAffected + " rows affected.");
		}
		else {
			System.out.println("Error: " + rowsAffected + " rows affected.");
		}
	}

}
