package Break;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Converter.EntityRetriever;
import Converter.TimeConverter;

public class BreakRetriever extends EntityRetriever<Break> {
	String sqlCommand = "Select breakID, breakStart, breakEnd, shiftID FROM break";
	
	@Override
	public Break convert(ResultSet resultSet) throws Exception{
		int breakID = resultSet.getInt("breakID");
		LocalDateTime breakStart = setIfNull(resultSet, "breakStart");
		LocalDateTime breakEnd = setIfNull(resultSet, "breakEnd");
		int shiftID = resultSet.getInt("shiftID");
		
		return new Break(breakID, breakStart, breakEnd, shiftID);
	}
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
	private LocalDateTime setIfNull(ResultSet resultSet, String breakTime) throws SQLException {
		if(resultSet.getTimestamp(breakTime) != null) {
			return TimeConverter.convertToLocalDateTime(resultSet.getTimestamp(breakTime));
		}
		else {
			return null;
		}
	}
}
