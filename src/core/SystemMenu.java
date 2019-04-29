package core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dbrequests.DatabaseRequest;

public class SystemMenu {
	
public static void runMenu() {
	ArrayList<DatabaseRequest> allRequests = DatabaseRequest.getAllRequests();
	Scanner keyboard = new Scanner(System.in);
	int choice = 0;
	while (choice < allRequests.size()) {
		displayMenu();
		choice = getChoice(keyboard);
		if (choice < allRequests.size()) {
			try {
				allRequests.get(choice).execute();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
				ex.printStackTrace();
			}
		} else if (choice > allRequests.size()) {
				System.out.println("Choice out of range. Try Again.");
		}
	}
	
}
	
	private static int getChoice(Scanner keyboard) {
		System.out.print("Selection: ");
		String selection = keyboard.nextLine();
		return Integer.parseInt(selection);
	}
	
	private static void displayMenu() {
		ArrayList<DatabaseRequest> choices = DatabaseRequest.getAllRequests();
		
		System.out.println("Choose an action:");
		for (int i = 0; i < choices.size(); i++) {
			System.out.println( i + ". " + choices.get(i).getDescription());
		}
		System.out.println(choices.size() + ". Quit");
	}

}
