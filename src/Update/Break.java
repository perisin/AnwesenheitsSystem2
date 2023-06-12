package Update;

import java.time.*;

public class Break {
	private LocalDateTime startBreak;
	private LocalDateTime endBreak;
	
	private int breakID;
	private int shiftID;
	
	public Break(int breakID, int shiftID) {
		this.breakID = breakID;
		this.shiftID = shiftID;
	}
	public Break(int breakID ,LocalDateTime startBreak, LocalDateTime endBreak, int shiftID) {
		this.breakID = breakID;
		this.startBreak = startBreak;
		this.endBreak = endBreak;
		this.shiftID = shiftID;
	}
	
	public LocalDateTime getStartBreak() {
		return startBreak;
	}
	public void setStartBreak(LocalDateTime startBreak) {
		this.startBreak = startBreak;
	}
	public LocalDateTime getEndBreak() {
		return endBreak;
	}
	public void setEndBreak(LocalDateTime endBreak) {
		this.endBreak = endBreak;
	}
	public int getTimeSpanID() {
		return breakID;
	}

	public int getShiftID() {
		return shiftID;
	}
}
