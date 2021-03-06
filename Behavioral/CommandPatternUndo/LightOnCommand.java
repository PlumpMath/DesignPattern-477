package CommandPatternUndo;

public class LightOnCommand implements Command {
	// Receiver物件
	Light light;

	// 透過建構子傳入Receiver物件，儲存到實體變數
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	// 透過Composition呼叫Receiver物件方法
	@Override
	public void execute() {
		light.on();
	}

	// undo動作要與execute相反
	@Override
	public void undo() {
		light.off();
	}
	
}
