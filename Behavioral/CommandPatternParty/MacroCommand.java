package CommandPatternParty;
// 用巨集指令執行一堆命令
public class MacroCommand implements Command {
	Command[] commands;
 
	// 巨集命令(MacroCommand用命令陣列儲存一大群命令)
	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}
	
	// 巨集命令被遙控器執行時，巨集命令會依序執行陣列裡每個命令
	public void execute() {
		for (int i = 0; i < commands.length; i++) {
			commands[i].execute();
		}
	}
 
    /**
     * NOTE:  these commands have to be done backwards to ensure proper undo functionality
     */
	public void undo() {
		for (int i = commands.length -1; i >= 0; i--) {
			commands[i].undo();
		}
	}
}

