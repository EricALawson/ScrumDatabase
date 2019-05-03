package dbrequests;

import util.InputValidator;

import java.sql.SQLException;

public class DeleteManagement extends DatabaseRequest{

	public DeleteManagement() {
		description = "Delete Engineer from Project Management";
	}

	@Override
    public void execute() throws SQLException {
        String sql = "DELETE FROM ManagementMembers WHERE ManagementMembers.EmployeeID = ? AND ManagementMembers.ProjectName = ?;";
        prepStmnt = conn.prepareStatement(sql);
        prepStmnt.setString(1, InputValidator.getEmployeeID());
        prepStmnt.setString(2, InputValidator.getProjectName());

	    try{
		int rows_affected = prepStmnt.executeUpdate();

		if (rows_affected > 0) {
		    System.out.println("Success: " + rows_affected + " rows affected.");
		} else if (rows_affected == 0) {
		    System.out.println("Failure: " + rows_affected + " rows affected.");
		}
		else {
		    System.out.println("Error: " + rows_affected + " rows affected.");
		}
	    }
		catch (SQLIntegrityConstraintViolationException e){
			System.out.println("Error: ");
			System.out.println(e);
		}
    }

}
