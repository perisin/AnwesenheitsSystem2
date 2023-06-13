package Update;

import java.time.LocalDateTime;

public class BreakManager {
	
	
	BreakRetriever breakRetriever;
	BreakEditor breakEditor;
	
	public BreakManager() {
		breakRetriever = new BreakRetriever();
		breakEditor = new BreakEditor();
	}
	
	public void startBreak(int shiftID) {
		Break _break = new Break(getLowestBreakID(), shiftID);
		_break.setBreakStart(LocalDateTime.now());
		breakEditor.insertEntity(_break);
	}
	public void endBreak(int breakID) {
		for(Break _break : breakRetriever.getEntitys()) {
			if(_break.getBreakID() == breakID) {
				_break.setBreakEnd(LocalDateTime.now());
				breakEditor.updateEntity(_break);
			}
		}
	}
	
	
	public int getLowestBreakID() {
		int lowestFreeID = 1;
		while(containsID(lowestFreeID)) {
			lowestFreeID++;
		}
		return lowestFreeID;
	}
	private boolean containsID(int id) {
		for(Break _break : breakRetriever.getEntitys()) {
			if(_break.getBreakID() == id) {
				return true;
			}
		}
		return false;
	}
}
