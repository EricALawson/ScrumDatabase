package dbrequests;

import util.InputValidator;

import java.sql.SQLException;
import java.sql.ResultSet;

public class ReadProjectSprints extends DatabaseRequest {
	
	public ReadProjectSprints() throws SQLException {
		description = "Read All Sprints in project";
		String sql = "SELECT Projects.ProjectName, Sprints.SprintID, Sprints.StartDate, Sprints.EndDate, Sprints.Status"
				+ " FROM Projects INNER JOIN Sprints ON Sprints.ProjectName = Projects.ProjectName WHERE Projects.ProjectName = ?;";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getProjectName());
		ResultSet rs = prepStmnt.executeQuery();
		printResultSet(rs);
	}
	
}
