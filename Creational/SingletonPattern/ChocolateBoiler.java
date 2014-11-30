package SingletonPattern;

// 使用雙重檢查上鎖(double-checked lock)
// 雙重檢查上鎖不適用於1.4以前的版本
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	// 定義一個靜態reference
	// volatile: 當chocolateBoiler變數被初始化成為Singleton實體時，多執行序處理此變數作法是正確的
	// Volatile修飾的成員變數在每次被線程訪問時，都強迫從共用記憶體中重讀該成員變數的值
	private volatile static ChocolateBoiler chocolateBoiler;
	
	// 程式開始時，鍋爐是空的(建構子設定為private)
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	// 透過一個存取全域點(public)，檢查靜態物件是否已產生時體。
	// 若無實體則呼叫private建構子new實體。
	// 在getInstance()前加上synchronized方法，迫使執行序進入方法前要先等候別的執行序離開此方法
	// 但是會降低效能(事實上只有在第一次執行此方法時才需要同步化)
	public static ChocolateBoiler getInstance() {
		// 檢查實體，如果不存在才進入同步區塊
		if (chocolateBoiler == null) {
			// 這邊只有在第一次才會進入同步區塊
			synchronized(ChocolateBoiler.class) {
				// 進入區塊後，再檢查一次。如果能是null才建立實體
				if (chocolateBoiler == null) {
					chocolateBoiler = new ChocolateBoiler();
				}
			}
		}
		return chocolateBoiler;
	}
	
	// 鍋爐填裝物質時，鍋內必須為空
	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}
	
	// 鍋爐倒出，必須是滿的且煮過的
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}
	
	// 煮混合物時，鍋爐必須是滿的且未煮過的
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
}
