package Break;

import Converter.EntityEditor;
import Converter.TimeConverter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;


public class BreakEditor extends EntityEditor<Break> {
	//break cannot be used as a variable, so it is called _break
	@Override
	public String getInsertCommand() {
		return "INSERT INTO break(breakID, breakStart, breakEnd, shiftID) values(?,?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, Break _break) throws SQLException {
		statement.setInt(1, _break.getBreakID());
		setIfNull(statement, 2, _break.getBreakStart());
		setIfNull(statement,3,_break.getBreakEnd());
		statement.setInt(4, _break.getShiftID());
	}
	@Override
	public String getUpdateCommand() {
		return "Update break set breakID = ?,breakStart = ?, breakEnd = ?, shiftID = ? WHERE breakID = ?";
	}
	
	@Override
	public void setUpdateStatementValues(PreparedStatement statement, Break _break) throws SQLException{
		statement.setInt(1, _break.getBreakID());
		setIfNull(statement, 2, _break.getBreakStart());
		setIfNull(statement,3,_break.getBreakEnd());
		statement.setInt(4, _break.getShiftID());
		statement.setInt(5, _break.getBreakID());
	}
	
	@Override
	public String getDeleteCommand(Break _break) {
		return "DELETE FROM break where breakID = " + _break.getBreakID();
	}
	
	private void setIfNull(PreparedStatement statement, int index, LocalDateTime breakTime) throws SQLException{
		if(breakTime != null)
			statement.setTimestamp(index, TimeConverter.convertToTimestamp(breakTime));
		else
			statement.setNull(index, Types.TIMESTAMP);
		
	}
}
