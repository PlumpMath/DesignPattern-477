package AdapterPatternDuckAdapter;

// 實踐想要轉成的型態
public class TurkeyAdapter implements Duck {
	Turkey turkey;
	
	// 透過建構式取得被轉換者物件的reference
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	// 透過合成實踐介面方法
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		// 火雞飛行距離短，需要飛5次
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}
	
}
