package dbrequests;

import java.sql.SQLException;

import util.InputValidator;

public class ReadSprintEngineers extends DatabaseRequest {
	public ReadSprintEngineers() throws SQLException {
		description = "Read Sprint Engineers of a Sprint";
		String sql = "SELECT SCRUMTeams.TeamName, SCRUMTeamMembers.EmployeeID, SoftwareEngineers.FirstName,"
				+ " SoftwareEngineers.LastName, SoftwareEngineers.PhoneNumber, SoftwareEngineers.Email, SoftwareEngineers.HireDate"
				+ " FROM Projects"
				+ " INNER JOIN SCRUMTeams ON SCRUMTeams.ProjectName = Projects.ProjectName"
				+ " INNER JOIN SCRUMTeamMembers ON SCRUMTeamMembers.TeamName = SCRUMTeams.TeamName"
				+ " INNER JOIN SoftwareEngineers ON SoftwareEngineers.EmployeeID = SCRUMTeamMembers.EmployeeID"
				+ " INNER JOIN SprintTeamMembers ON SprintTeamMembers.EmployeeID = SCRUMTeamMembers.EmployeeID AND"
				+ " SprintTeamMembers.TeamName = SCRUMTeamMembers.TeamName"
				+ " WHERE SprintTeamMembers.SprintID = ?";
		prepStmnt = conn.prepareStatement(sql);
	}
	
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getSprintID());
		prepStmnt.executeQuery();
	}
}
