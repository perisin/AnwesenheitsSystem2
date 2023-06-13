package Update;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShiftEditor extends EntityEditor<Shift>{
		
	@Override
	public String getInsertCommand() {
		return "INSERT INTO employee(shiftID, shiftStart, shiftEnd, employeeID) values(?,?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, Shift shift) throws SQLException {
		statement.setInt(1, shift.getShiftID());
		statement.setTimestamp(2, TimeConverter.localtimeToTimestamp(shift.getShiftStart()));
		statement.setTimestamp(2, TimeConverter.localtimeToTimestamp(shift.getShiftStart()));
		statement.setInt(4, shift.getEmployeeID());
	}

	
	@Override
	public String getDeleteCommand(Shift shift) {
		return "DELETE FROM shifts where shiftID = " + shift.getShiftID();
	}
}
