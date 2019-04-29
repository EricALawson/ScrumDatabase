package dbrequests;

import java.sql.SQLException;

public class ReadProjectStories extends DatabaseRequest{

	public ReadProjectStories() throws SQLException {
		description = "Read Project Stories";
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
		
		
	}
}
