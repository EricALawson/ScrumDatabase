package util;

import java.sql.Date;

import java.util.Scanner;

public class InputValidator {
	private static Scanner keyboard = new Scanner(System.in);
	
	public static String getStartDate() {
		System.out.println("Enter Year for the start date: ");
		int year = Integer.parseInt(keyboard.nextLine());
		System.out.println("Enter Month for the start date: ");
		int month = Integer.parseInt(keyboard.nextLine());
		System.out.println("Enter Day for the start date: ");
		int day = Integer.parseInt(keyboard.nextLine());
		return year + "-" + month + "-" + day;
	}
	
	public static String getEndDate() {
		System.out.println("Enter Year for the end date: ");
		int year = Integer.parseInt(keyboard.nextLine());
		System.out.println("Enter Month for the end date: ");
		int month = Integer.parseInt(keyboard.nextLine());
		System.out.println("Enter Day for the end date: ");
		int day = Integer.parseInt(keyboard.nextLine());
		return year + "-" + month + "-" + day;
	}

	public static String getSprintID() {
		System.out.println("Enter the sprint ID: ");
		String id = keyboard.nextLine();
		return id;
	}
	
	public static String getEmployeeID() {
		System.out.println("Enter the Employee ID: ");
		String id = keyboard.nextLine();
		return id;
	}
	
	//Create Story
	public static String getUserStoryID() {
		System.out.println("Enter the User Story ID: ");
		String id = keyboard.nextLine();
		return id;
	}
	
	public static String getRole() {
		System.out.println("Enter the role: ");
		String role = keyboard.nextLine();
		return role;
	}
	
	public static String getGoal() {
		System.out.println("Enter the goal: ");
		String goal = keyboard.nextLine();
		return goal;
	}
	
	public static String getBenefit() {
		System.out.println("Enter the benefit: ");
		String benefit = keyboard.nextLine();
		return benefit;
	}
	
	public static String getTeamName() {
		System.out.println("Enter the team name: ");
		String str = keyboard.nextLine();
		return str;
	}
	
	
	public static String getStatus() {
		while(true) {
			System.out.println("Choose status\n1) Done\n2) Ongoing\n3) Project backlog");
			int option = Integer.parseInt(keyboard.nextLine());
			switch(option) {
			case 1: return "Done";
			case 2: return "Ongoing";
			case 3: return "Project backlog";
			}
			System.out.println("Invalid input");
		}
	}
	
	public static String getProjectName() {
		System.out.println("Enter the project name: ");
		String str = keyboard.nextLine();
		return str;
	}
	
	public static String getManagementColumn() {
		while (true) {
			System.out.println("Choose column: ");
			System.out.println("1) Project Name");
			System.out.println("2) Employee ID");
			String option = keyboard.nextInt();
			switch(option) {
			case "1": return "ProjectName";
			case "2": return "EmployeeID";
			default: System.out.println("Invalid input");
			}
		}
	}
	
	public static String getProjectStoryColumn() {
		while (true) {
			System.out.println("Choose column: ");
			System.out.println("1) User Story ID");
			System.out.println("2) Project Name");
			System.out.println("3) Role");
			System.out.println("4) Goal");
			System.out.println("5) Benefit");
			String option = keyboard.nextInt();
			switch(option) {
			case "1": return "USID";
			case "2": return "ProjectName";
			case "3": return "Role";
			case "4": return "Goal";
			case "5": return "Benefit";
			default: System.out.println("Invalid input");
			}
		}
	}
	
	public static String getSprintTeamMember() {
		while (true) {
			System.out.println("Choose column: ");
			System.out.println("1) Team Name");
			System.out.println("2) Employee ID");
			System.out.println("3) Sprint ID");
			String option = keyboard.nextInt();
			switch(option) {
			case "1": return "USID";
			case "2": return "ProjectName";
			case "3": return "Role";
			case "4": return "Goal";
			case "5": return "Benefit";
			default: System.out.println("Invalid input");
			}
		}
	}

}
