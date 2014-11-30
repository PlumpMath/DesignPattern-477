package CommandPatternUndo;

// 命令物件介面
public interface Command {
	// 提供一個execute方法
	public void execute();
	// 加入Undo功能，回覆上一動
	public void undo();
}
