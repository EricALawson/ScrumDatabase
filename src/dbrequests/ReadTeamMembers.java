package dbrequests;

import java.sql.SQLException;

import util.InputValidator;
import java.sql.ResultSet;

public class ReadTeamMembers extends DatabaseRequest{

	public ReadTeamMembers() throws SQLException {
		description = "Read Team Members of a Project";
		String sql = "SELECT SCRUMTeamMembers.EmployeeID, SoftwareEngineers.FirstName, SoftwareEngineers.LastName,"
				+ " SoftwareEngineers.PhoneNumber, SoftwareEngineers.Email, SoftwareEngineers.HireDate" + 
				" FROM Projects" + 
				" INNER JOIN SCRUMTeams" + 
				" ON SCRUMTeams.ProjectName = Projects.ProjectName" + 
				" INNER JOIN SCRUMTeamMembers" + 
				" ON SCRUMTeamMembers.TeamName = SCRUMTeams.TeamName" + 
				" INNER JOIN SoftwareEngineers" + 
				" ON SoftwareEngineers.EmployeeID = SCRUMTeamMembers.EmployeeID" + 
				" WHERE Projects.ProjectName = ?;";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getProjectName());
		ResultSet rs = prepStmnt.executeQuery();
		printResultSet(rs);
	}
	
}
