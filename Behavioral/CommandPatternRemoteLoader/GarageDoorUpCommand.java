package CommandPatternRemoteLoader;

public class GarageDoorUpCommand implements Command {
	// Receiver物件
	GarageDoor garageDoor;

	// 透過建構子傳入Receiver物件，儲存到實體變數
	public GarageDoorUpCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}
	
	// 透過Composition呼叫Receiver物件方法
	@Override
	public void execute() {
		garageDoor.up();
	}
	
}
