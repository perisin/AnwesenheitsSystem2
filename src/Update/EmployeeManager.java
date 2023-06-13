package Update;


public class EmployeeManager {
	
	private EmployeeEditor employeeEditor;
	
	public boolean isCorrectPassword(Employee employee, String password) {
		if(employee.getPassword() == password) {
			return true;
		}
		return false;
	}
	
	public boolean isAdmin(Employee employee) {
		return employee.getIs_admin();
	}

	public void createEmployee(Employee employee) {
		employee.setEmployeeID(getLowestEmployeeID());
		employeeEditor.insertEntity(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		employeeEditor.deleteEntity(employee);
	}
	
	public int getLowestEmployeeID() {
		return 0;
	}
}
