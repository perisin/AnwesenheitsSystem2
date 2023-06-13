package Update;

import java.time.LocalDateTime;

public class ShiftManager {
	
	private Integer activeShiftID;
	private Integer activeBreakID;
	
	private BreakManager breakManager;
	
	private ShiftEditor shiftEditor;
	
	public ShiftManager() {
		breakManager = new BreakManager();
	}
	
	public void startShift(Employee employee) {
		if(activeShiftID == null) {
			Shift shift = new Shift(getLowestShiftID(), employee.getEmployeeID());
			shift.setShiftStart(LocalDateTime.now());
			activeShiftID = shift.getShiftID();
			shiftEditor.insertEntity(shift);			
		}
	}
	
	public void endShift() {
		if(activeShiftID != null && activeBreakID == null) {
			activeShiftID = null;
			//update shift with endshift			
		}
	}
	
	public void startBreak() {
		activeBreakID = breakManager.getLowestBreakID();
		breakManager.startBreak(activeShiftID);
	}
	
	public int getLowestShiftID() {
		return 0;
	}
}
