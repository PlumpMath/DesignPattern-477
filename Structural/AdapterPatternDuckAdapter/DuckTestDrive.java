package AdapterPatternDuckAdapter;

public class DuckTestDrive {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 建立一隻綠頭鴨
		MallardDuck mallardDuck = new MallardDuck();
		// 建立一隻火雞
		WildTurkey turkey = new WildTurkey();
		// 將火雞包進一個火雞轉接器中，讓他看起來像鴨子
		Duck TurkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nThe Duck says...");
		testDuck(mallardDuck);
		
		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(TurkeyAdapter);
	}
	// 取得一隻鴨子，呼叫他的方法
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}

}
