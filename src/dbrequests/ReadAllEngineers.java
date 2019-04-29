package dbrequests;


import java.sql.SQLException;
import util.InputValidator;

public class ReadAllEngineers extends DatabaseRequest {

	public ReadAllEngineers() throws SQLException {
		description = "Read All Engineers";
		String sql = "SELECT * FROM SoftwareEngineers;";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.executeQuery();
	}

}
