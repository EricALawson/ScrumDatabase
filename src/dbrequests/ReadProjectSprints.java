package dbrequests;

import util.InputValidator;
import java.sql.SQLException;

public class ReadProjectSprints extends DatabaseRequest {
	
	public ReadProjectSprints() throws SQLException {
		description = "Read All Project Engineers";
		String sql = "SELECT Projects.ProjectName, Sprints.SprintID, Sprints.StartDate, Sprints.EndDate, Sprints.Status"
				+ " FROM Projects INNER JOIN Sprints ON Sprints.ProjectName = Projects.ProjectName WHERE Projects.ProjectName = ?;";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getProjectName());
		prepStmnt.executeQuery();
	}
	
}
