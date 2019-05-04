package dbrequests;

import util.InputValidator;

import java.sql.SQLException;
import java.sql.ResultSet;

public class ReadProjectStories extends DatabaseRequest{

	public ReadProjectStories() throws SQLException {
		description = "Read User Stories of a Project";
		String sql = "SELECT UserStories.USID, UserStories.Role, UserStories.Goal, UserStories.Benefit" + 
				" FROM Projects" + 
				" INNER JOIN UserStories" + 
				" ON UserStories.ProjectName = Projects.ProjectName" + 
				" INNER JOIN SprintStories" + 
				" ON SprintStories.USID = UserStories.USID" + 
				" WHERE SprintID IS NOT NULL AND Projects.ProjectName = ?;";
		prepStmnt = conn.prepareStatement(sql);
	}

	@Override
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getProjectName());
		ResultSet rs = prepStmnt.executeQuery();
		printResultSet(rs);
	}
}
