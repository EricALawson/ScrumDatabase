package dbrequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

public abstract class DatabaseRequest {
	private static ArrayList<DatabaseRequest> allRequests = new ArrayList<>();
	protected static Connection conn;
	protected PreparedStatement prepStmnt;
	protected String description;

	public DatabaseRequest() {
		allRequests.add(this);
	}
	
	public abstract void execute() throws SQLException;
	
	public String getDescription() {
		return description;
	}
	
	public static ArrayList<DatabaseRequest> getAllRequests() {
		return allRequests;
	}
	
	public static void setConnection(Connection newConn) {
		conn = newConn;
	}

	public static void initializeRequests() {
		try {
			new CreateProject();
			new CreateSprint();
			new CreateManagement();
			new CreateSprintMember();
			new CreateStory();
			new CreateTeamMember();
			new DeleteManagement();
			new DeleteProjectStory();
			new DeleteSprintTeamMember();
			new InsertSprintStory();
			new ReadAllEngineers();
			new ReadSprintEngineers();
			new ReadProjectSprints();
			new ReadProjectStories();
			new ReadTeamMembers();
			new ReadTeams();
			new UpdateManagement();
			new UpdateProjectStory();
			new UpdateSprintTeamMember();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
	}
	
	protected void printResultSet(ResultSet results) throws SQLException {
		ResultSetMetaData rsmd = results.getMetaData();
		int numberCols = rsmd.getColumnCount();
		for (int i = 1; i <= numberCols; i++) {
			System.out.printf("%-25s",rsmd.getColumnLabel(i));
		}
		System.out.println("\n---------------------------");
		while (results.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i ++) {
				//if (i > 1) System.out.print(",\t\t");
				String colValue = results.getString(i);
				System.out.printf("%-25s",colValue);
			}
			System.out.println();
		}
		System.out.println();
	}
	//still working on this -izzy
	/**
	 * will format the resultset using system.out.format()
	 */
	protected void formatResultSet(ResultSet results) throws SQLException {
		ResultSetMetaData rsmd = results.getMetaData();
		int numberCols = rsmd.getColumnCount();
		String[] colNum = new String[numberCols];
		for (int i = 0; i < numberCols; i++) {
			// Adds column names to the array
			colNum[i] = rsmd.getColumnName(i + 1);
			String tableName = rsmd.getTableName(i);
//			ResultSet rs = conn.executeUpdate("SELECT MAX(LENGTH(" + rsmd.getColumnName(i + 1) + ")) from " + tableName);
//			ResultSetMetaData rsmd2= rs.getMetaData();
			
		}
		System.out.println("\n---------------------------");
		while (results.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i ++) {
				if (i > 1) System.out.print(",\t\t");
				String colValue = results.getString(i);
				System.out.print(colValue);
			}
			System.out.println();
		}
		System.out.println();
	}
}
