package dbrequests;

import java.sql.SQLException;
import java.sql.ResultSet;

public class ReadAllEngineers extends DatabaseRequest {

	public ReadAllEngineers() throws SQLException {
		description = "Read all Engineers";
		String sql = "SELECT * FROM SoftwareEngineers";
		prepStmnt = conn.prepareStatement(sql);

	}

	public void execute() throws SQLException {
		ResultSet resultSet = prepStmnt.executeQuery();
		printResultSet(resultSet);
	}
}