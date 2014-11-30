package CommandPatternSimpleRemote;

// 調用者(invoker)
public class SimpleRemoteControl {
	// 設定一個插槽持有Command
	Command slot;
	
	public SimpleRemoteControl() {}
	
	// 設定控制插槽的Command
	public void setCommand(Command command) {
		this.slot = command;
	}
	
	// 按下插槽時，呼叫Command的execute方法
	public void buttonWasPressed() {
		slot.execute();
	}
}
