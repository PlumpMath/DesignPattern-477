package DecoratorPattern;

public class Espresso extends Beverage {
	// 透過建構式設定飲料的描述，description是super class的變數
	public Espresso() {
		description = "Espresso";
	}
	
	// 計算價格時，直接將Espresso價格傳回即可
	public double cost() {
		return 1.99;
	}

}
