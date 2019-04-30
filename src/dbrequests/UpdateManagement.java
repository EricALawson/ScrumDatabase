package dbrequests;

import java.sql.SQLException;
import java.util.Scanner;

import util.InputValidator;
public class UpdateManagement extends DatabaseRequest{
	private static Scanner keyboard = new Scanner(System.in);
	
	public UpdateManagement() throws SQLException{
		description = "Update Management";
		String sql = "";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public static String setManagementCols() {
		while (true) {
			System.out.println("Choose column: ");
			System.out.println("1) Project Name");
			System.out.println("2) Employee ID");
			int option = keyboard.nextInt();
			switch(option) {
			case 1: return "ProjectName";
			case 2: return "EmployeeID";
			default: System.out.println("Invalid input");
			}
		}
	}
	
	@Override
	public void execute() throws SQLException {
		String setColumn;
		String findColumn;
		System.out.println("Which column do you want to update?");
		setColumn = setManagementCols();
		System.out.println("Which column do you want to set a condition under?");
		findColumn = setManagementCols();
		
		String sql = "UPDATE ManagementMembers SET ManagementMembers." + setColumn + " = ? WHERE ManagementMembers." + findColumn + " = ?;";
		prepStmnt = conn.prepareStatement(sql);
		
		System.out.println("What is the update value?");
		if (setColumn == "ProjectName")
			prepStmnt.setString(1, InputValidator.getProjectName());
		else if (setColumn == "EmployeeID")
			prepStmnt.setString(1, InputValidator.getEmployeeID());
		
		System.out.println("What is the condition value?");
		if (findColumn == "ProjectName")
			prepStmnt.setString(2, InputValidator.getProjectName());
		else if (findColumn == "EmployeeID")
			prepStmnt.setString(2, InputValidator.getEmployeeID());
				
		prepStmnt.executeUpdate();
	}

}
