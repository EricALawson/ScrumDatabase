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
}
