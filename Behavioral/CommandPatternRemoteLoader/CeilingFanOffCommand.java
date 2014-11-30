package CommandPatternRemoteLoader;

public class CeilingFanOffCommand implements Command {
	// Receiver物件
	CeilingFan ceilingFan;

	// 透過建構子傳入Receiver物件，儲存到實體變數
	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	
	// 透過Composition呼叫Receiver物件方法
	@Override
	public void execute() {
		ceilingFan.off();
	}
	
}
