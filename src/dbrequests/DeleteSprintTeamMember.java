package dbrequests;

import util.InputValidator;

import java.sql.SQLException;

public class DeleteSprintTeamMember extends DatabaseRequest{

	public DeleteSprintTeamMember() throws SQLException{
		description = "Remove a member from a sprint";
		String sql = "DELETE from SprintTeamMembers WHERE TeamName = ? AND EmployeeID = ? AND SprintID = ?;";
		prepStmnt = conn.prepareStatement(sql);
	}

	@Override
	public void execute() throws SQLException {
		prepStmnt.setString(1, InputValidator.getTeamName());
		prepStmnt.setString(2, InputValidator.getEmployeeID());
		prepStmnt.setString(3, InputValidator.getSprintID());
		int removed = prepStmnt.executeUpdate();

		if (removed > 0) {
			System.out.println("Success: " + removed + " rows deleted");
		} else {
			System.out.println("No matching team members were found.");
		}
		
	}

}
