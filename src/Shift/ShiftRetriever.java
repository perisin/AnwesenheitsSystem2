package Shift;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Converter.EntityRetriever;
import Converter.TimeConverter;

public class ShiftRetriever extends EntityRetriever<Shift> {
	String sqlCommand = "Select shiftID, shiftStart, shiftEnd, employeeID FROM shift";
	
	@Override
	public Shift convert(ResultSet resultSet) throws Exception{
		int shiftID = resultSet.getInt("shiftID");
		LocalDateTime shiftStart = setIfNull(resultSet, "shiftStart");
		LocalDateTime shiftEnd = setIfNull(resultSet, "shiftEnd");
		int employeeID = resultSet.getInt("employeeID");
		
		return new Shift(shiftID, shiftStart, shiftEnd, employeeID);
	}
	
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
	private LocalDateTime setIfNull(ResultSet resultSet, String shiftTime) throws SQLException {
		if(resultSet.getTimestamp(shiftTime) != null) {
			return TimeConverter.convertToLocalDateTime(resultSet.getTimestamp(shiftTime));
		}
		else {
			return null;
		}
	}
}
