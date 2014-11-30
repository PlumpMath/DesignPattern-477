package CommandPatternUndo;

public class CeilingFanHighCommand implements Command {
	CeilingFan ceilingFan;
	// 紀錄吊扇之前的速度
	int prevSpeed;
  
	public CeilingFanHighCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
 
	public void execute() {
		// 改變吊扇速度前，先記錄之前的速度
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.high();
	}
 
	public void undo() {
		// 將吊扇設定為之前速度
		if (prevSpeed == CeilingFan.HIGH) {
			ceilingFan.high();
		} else if (prevSpeed == CeilingFan.MEDIUM) {
			ceilingFan.medium();
		} else if (prevSpeed == CeilingFan.LOW) {
			ceilingFan.low();
		} else if (prevSpeed == CeilingFan.OFF) {
			ceilingFan.off();
		}
	}
}
