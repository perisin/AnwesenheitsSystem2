package GUI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Break.Break;
import Employee.Employee;
import Shift.*;


public class AttendanceTextBox {
	WindowStateMachine stateMachine;
	ShiftManager shiftManager ;
	public AttendanceTextBox(WindowStateMachine stateMachine) {
		this.stateMachine = stateMachine;
		shiftManager = stateMachine.getShiftManager();
	}
	public String setText() {
		String text = "";
		for(Shift shift : getLatestShifts(stateMachine.getCurrentEmployee(), 2)) {
			text += (shift.getShiftStart() != null) ? "Shift start at: " + shift.getShiftStart() + "\n" : "";
			for(Break _break : getShiftBreaks(shift)) {
				text += (_break.getBreakStart() != null) ? "Break start at: " + _break.getBreakStart() + "\n" : "";
				text += (_break.getBreakEnd() != null) ? "Break ends at: " + _break.getBreakEnd() + "\n" : "";
			}
			text += (shift.getShiftEnd() != null) ? "Shift end at: " + shift.getShiftEnd() + "\n" : "";
		}
		return text;
	}
	
	private List<Shift> getLatestShifts(Employee employee, int maxShifts){
		List<Shift> shifts = new ArrayList<Shift>();
		LocalDateTime latestShift = LocalDateTime.MIN;
		for(Shift shift : stateMachine.getShiftRetriever().getEntitys()) {
			if(shift.getShiftStart().isAfter(latestShift) && shift.getEmployeeID() == shift.getEmployeeID()) {
				shifts.add(shift);
				latestShift = shift.getShiftStart();
			}
		}
		if(shifts.size() > 2) {
			shifts.subList(0, shifts.size() - 2).clear();
		}
		return shifts;
	}
	private List<Break> getShiftBreaks(Shift shift){
		List<Break> breaks = new ArrayList<Break>();
		for(Break _break : stateMachine.getBreakRetriever().getEntitys()) {
			if(_break.getShiftID() == shift.getShiftID()) {
				breaks.add(_break);
			}
		}
		return breaks;
	}
	
}
