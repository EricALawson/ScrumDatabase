package dbrequests;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTeams extends DatabaseRequest{
	
	public ReadTeams() throws SQLException {
		description = "Read SCRUM Teams";
		String sql = "SELECT * FROM SCRUMTeams;";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		ResultSet rows_affected = prepStmnt.executeQuery();
		printResultSet(rows_affected);
		prepStmnt.executeQuery();
	}
}
