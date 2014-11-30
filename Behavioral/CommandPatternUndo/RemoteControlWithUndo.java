package CommandPatternUndo;

public class RemoteControlWithUndo {
	// 遙控器要處理七個開與關指令，使用陣列紀錄指令
	Command[] onCommands;
	Command[] offCommands;
	// 記錄前一個命令的物件變數
	Command undoCommand;
	
	public RemoteControlWithUndo() {
		// 建構子只需要初始化開與關陣列物件
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		Command noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		// 一開始沒有"前一個命令"，所以設定為NoCommand
		undoCommand = noCommand;
	}
	
	/**
	 *  將變數紀錄在陣列中對應的插槽
	 * @param slot 插槽位置
	 * @param onCommand 開命令
	 * @param offCommand 關命令
	 */
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	
	// 按下開按鈕，呼叫對應command(再呼叫Receiver)
	public void onButtonWasPushed(int slot) {
		// notice: 若不想每次使用前都要檢查是否有物件
		// 透過空物件(NoCommand 建構子時Assign)將處理null的責任轉移給空物件
		onCommands[slot].execute();
		// 按下按鈕時，順便將命令紀錄在undoCommand實體變數中
		undoCommand = onCommands[slot];
	}
	
	// 按下關按鈕，呼叫對應command(再呼叫Receiver)
	public void offButtonWasPushed(int slot) {
		// notice: 若不想每次使用前都要檢查是否有物件
		// 透過空物件(NoCommand 建構子時Assign)將處理null的責任轉移給空物件
		offCommands[slot].execute();
		// 按下按鈕時，順便將命令紀錄在undoCommand實體變數中
		undoCommand = offCommands[slot];
	}
	
	public void undoButtonWasPushed() {
		undoCommand.undo();
	}
	
	// 印出每個插槽對應的命令
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	} 
}
