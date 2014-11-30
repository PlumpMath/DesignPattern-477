package TemplateMethodPatternCaffeine;

public abstract class CaffeineBeverage {
	// 將茶/咖啡沖泡方法封裝成一個演算法樣板
	final void prepareRecipe() {
		// 燒開水...此方法茶與咖啡都一樣，由超類別實踐
		boilWater();
		// 沖泡...此方法茶與咖啡大致一樣，細節由次類別實踐
		brew();
		// 倒入杯子中...此方法茶與咖啡都一樣，由超類別實踐
		pourInCup();
		// 加調味料...此方法茶與咖啡大致一樣，細節由次類別實踐
		addCondiments();
	}
	// 由次類別實踐的方法宣告為abstract
	abstract void brew();
  
	abstract void addCondiments();
 
	void boilWater() {
		System.out.println("Boiling water");
	}
  
	void pourInCup() {
		System.out.println("Pouring into cup");
	}
}
