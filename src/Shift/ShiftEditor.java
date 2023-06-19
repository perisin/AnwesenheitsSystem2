package Shift;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;

import Converter.EntityEditor;
import Converter.TimeConverter;

public class ShiftEditor extends EntityEditor<Shift>{
		
	@Override
	public String getInsertCommand() {
		return "INSERT INTO shift(shiftID, shiftStart, shiftEnd, employeeID) values(?,?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, Shift shift) throws SQLException {
		statement.setInt(1, shift.getShiftID());
		setIfNull(statement, 2, shift.getShiftStart());
		setIfNull(statement, 3, shift.getShiftEnd());
		statement.setInt(4, shift.getEmployeeID());
	}
	@Override
	public String getUpdateCommand() {
		return "Update shift set shiftID = ?, shiftStart = ?, shiftEnd = ?, employeeID = ? WHERE shiftID = ?";
	}
	
	@Override
	public void setUpdateStatementValues(PreparedStatement statement, Shift shift) throws SQLException{
		statement.setInt(1, shift.getShiftID());
		setIfNull(statement, 2, shift.getShiftStart());
		setIfNull(statement, 3, shift.getShiftEnd());
		statement.setInt(4, shift.getEmployeeID());
		statement.setInt(5, shift.getShiftID());
	}
	
	@Override
	public String getDeleteCommand(Shift shift) {
		return "DELETE FROM shift where shiftID = " + shift.getShiftID();
	}
	
	private void setIfNull(PreparedStatement statement, int index, LocalDateTime shiftTime) throws SQLException{
		if(shiftTime != null)
			statement.setTimestamp(index, TimeConverter.convertToTimestamp(shiftTime));
		else
			statement.setNull(index, Types.TIMESTAMP);
		
	}
}
