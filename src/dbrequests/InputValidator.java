package dbrequests;

import java.sql.Date;
import java.util.Scanner;

public class InputValidator {
	private static Scanner keyboard = new Scanner(System.in);
	
	public static String getDate() {
		System.out.println("Enter Year:");
		int year = Integer.parseInt(keyboard.nextLine());
		System.out.println("Enter Month:");
		int month = Integer.parseInt(keyboard.nextLine());
		System.out.println("Enter Day:");
		int day = Integer.parseInt(keyboard.nextLine());
		return year + "-" + month + "-" + day;
	}
	

	public static String getProjectName() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the project name:");
		String str = keyboard.nextLine();
		return str;
	}
}
