package Update;

import java.time.LocalDateTime;

public class BreakManager {
	
	public void startBreak(int shiftID) {
		Break _break = new Break(getLowestBreakID(), shiftID);
		_break.setStartBreak(LocalDateTime.now());
		// write break
	}
	
	public int getLowestBreakID() {
		return 0;
	}
}
