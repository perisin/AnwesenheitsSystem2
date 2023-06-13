package Update;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeEditor extends EntityEditor<Employee> {
	@Override
	public String getInsertCommand() {
		return "INSERT INTO employee(employeeID, firstName, lastName, password, is_Admin) values(?,?,?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, Employee employee) throws SQLException {
		statement.setInt(1, employee.getEmployeeID());
		statement.setString(2, employee.getFirstName());
		statement.setString(3, employee.getLastName());
		statement.setString(4, employee.getPassword());
		statement.setBoolean(5, employee.getIs_admin());
	}

	
	@Override
	public String getDeleteCommand(Employee employee) {
		return "DELETE FROM employee where employeeID = " + employee.getEmployeeID();
	}
}
