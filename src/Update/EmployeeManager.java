package Update;

import PreOrganized.Employee;

public class EmployeeManager {
	
	public boolean isCorrectPassword(Employee employee, String password) {
		if(employee.getPassword() == password) {
			return true;
		}
		return false;
	}
	
	public boolean isAdmin(Employee employee) {
		return employee.getIs_admin();
	}
	// create and delete employees
}
