package Update;

import java.time.LocalDateTime;

public class ShiftManager {
	
	private Integer activeShiftID;
	private Integer activeBreakID;
	
	private BreakManager breakManager;
	
	private ShiftRetriever shiftRetriever;
	private ShiftEditor shiftEditor;
	
	public ShiftManager() {
		shiftRetriever = new ShiftRetriever();
		shiftEditor = new ShiftEditor();
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
			for(Shift shift : shiftRetriever.getEntitys()) {
				if(activeShiftID == shift.getShiftID()) {
					shift.setShiftEnd(LocalDateTime.now());
					shiftEditor.updateEntity(shift);
				}
			}
			activeShiftID = null;
		}
	}
	
	public void startBreak() {
		activeBreakID = breakManager.getLowestBreakID();
	}
	public void endBreak() {
		
	}
	
	public int getLowestShiftID() {
		int lowestFreeID = 1;
		while(containsID(lowestFreeID)) {
			lowestFreeID++;
		}
		return lowestFreeID;
	}
	private boolean containsID(int id) {
		for(Shift shift : shiftRetriever.getEntitys()) {
			if(shift.getShiftID() == id) {
				return true;
			}
		}
		return false;
	}
	
	public Integer getActiveShiftID() {
		return activeShiftID;
	}
	public Integer getActiveBreakID() {
		return activeBreakID;
	}
}
