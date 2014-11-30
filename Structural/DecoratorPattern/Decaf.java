package DecoratorPattern;

public class Decaf extends Beverage {
	// 透過建構式設定飲料的描述，description是super class的變數
	public Decaf() {
		description = "Decaf";
	}
	
	// 計算價格時，直接將Decaf價格傳回即可
	public double cost() {
		return 1.05;
	}

}
