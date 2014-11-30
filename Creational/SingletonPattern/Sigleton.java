package SingletonPattern;

public class Sigleton {
	// 利用一個靜態變數記錄Sigleton類別的實體
	private static Sigleton uniqueInstance;
	
	// 建構式宣告為private，只有在Sigleton類別中才能呼叫此建構式建立物件
	
	public static Sigleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Sigleton();
		}
		return uniqueInstance;
	}
	
	public static void main(String[] args) {
		// 主程式透過getInstance()方法取得獨一無二的物件
		Sigleton sigleton = Sigleton.getInstance();
		
	}
}
