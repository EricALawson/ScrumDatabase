package dbrequests;

import java.sql.SQLException;
import java.util.Scanner;

import util.InputValidator;

public class UpdateSprintTeamMember extends DatabaseRequest{

	private static Scanner keyboard = new Scanner(System.in);
	
	public UpdateSprintTeamMember() throws SQLException{
		description = "Update Sprint Team Member";
		String sql = "";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public static String setSprintTeamMemberCols() {
		while (true) {
			System.out.println("Choose column: ");
			System.out.println("1) Team Name");
			System.out.println("2) Employee ID");
			System.out.println("3) Sprint ID");
			
			int option = keyboard.nextInt();
			switch(option) {
			case 1: return "TeamName";
			case 2: return "EmployeeID";
			case 3: return "SprintID";
			default: System.out.println("Invalid input");
			}
		}
	}
	@Override
	public void execute() throws SQLException {
		String setColumn, findColumn;
		
		System.out.println("Which column do you want to update?");
		setColumn = setSprintTeamMemberCols();
		System.out.println("Which column do you want to set a condition under?");
		findColumn = setSprintTeamMemberCols();
		
		
		String sql = "UPDATE SprintTeamMembers SET SprintTeamMembers." + setColumn + " = ? WHERE SprintTeamMembers." + findColumn + " = ?;";
		prepStmnt = conn.prepareStatement(sql);
		
		if (setColumn == "TeamName")
			prepStmnt.setString(1, InputValidator.getProjectName());
		else if (setColumn == "EmployeeID")
			prepStmnt.setString(1, InputValidator.getEmployeeID());
		else if (setColumn == "SprintID")
			prepStmnt.setString(1, InputValidator.getSprintID());
		
		System.out.println("What is the condition value?");
		if (findColumn == "ProjectName")
			prepStmnt.setString(2, InputValidator.getProjectName());
		else if (findColumn == "EmployeeID")
			prepStmnt.setString(2, InputValidator.getEmployeeID());
		else if (findColumn == "SprintID")
			prepStmnt.setString(2, InputValidator.getSprintID());
		
		prepStmnt.executeUpdate();
	}

}
