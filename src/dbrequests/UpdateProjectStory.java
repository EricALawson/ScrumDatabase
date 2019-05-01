package dbrequests;

import java.sql.SQLException;
import java.util.Scanner;

import util.InputValidator;

public class UpdateProjectStory extends DatabaseRequest{
	private static Scanner keyboard = new Scanner(System.in);
	
	public UpdateProjectStory() throws SQLException{
		description = "Update Project Story";
		String sql = "";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public static String setProjectStoryCols() {
		while (true) {
			System.out.println("Choose column: ");
			System.out.println("1) User Story ID");
			System.out.println("2) Project Name");
			System.out.println("3) Role");
			System.out.println("4) Goal");
			System.out.println("5) Benefit");
			int option = keyboard.nextInt();
			switch(option) {
			case 1: return "USID";
			case 2: return "ProjectName";
			case 3: return "Role";
			case 4: return "Goal";
			case 5: return "Benefit";
			default: System.out.println("Invalid input");
			}
		}
	}
	@Override
	public void execute() throws SQLException {
		String setColumn;
		String findColumn;
		System.out.println("Which column do you want to update?");
		setColumn = setProjectStoryCols();
		System.out.println("Which column do you want to set a condition under?");
		findColumn = setProjectStoryCols();

		String sql = "UPDATE UserStories INNER JOIN SprintStories ON UserStories.USID = SprintStories.USID SET UserStories."
		+ setColumn + " = ? WHERE SprintStories.SprintID IS NOT NULL AND UserStories." + findColumn + " = ?;";
		prepStmnt = conn.prepareStatement(sql);
		
		System.out.println("What is the update value?");
		if (setColumn == "USID")
			prepStmnt.setString(1, InputValidator.getUserStoryID());
		else if (setColumn == "ProjectName")
			prepStmnt.setString(1, InputValidator.getProjectName());
		else if (setColumn == "Role")
			prepStmnt.setString(1, InputValidator.getRole());
		else if (setColumn == "Goal")
			prepStmnt.setString(1, InputValidator.getGoal());
		else if (setColumn == "Benefit")
			prepStmnt.setString(1, InputValidator.getBenefit());
		
		System.out.println("What is the condition value?");
		if (findColumn == "USID")
			prepStmnt.setString(2, InputValidator.getUserStoryID());
		else if (findColumn == "ProjectName")
			prepStmnt.setString(2, InputValidator.getProjectName());
		else if (findColumn == "Role")
			prepStmnt.setString(2, InputValidator.getRole());
		else if (findColumn == "Goal")
			prepStmnt.setString(2, InputValidator.getGoal());
		else if (findColumn == "Benefit")
			prepStmnt.setString(2, InputValidator.getBenefit());
		

		prepStmnt.executeUpdate();
	}
	
}
