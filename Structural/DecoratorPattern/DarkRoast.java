package DecoratorPattern;

public class DarkRoast extends Beverage {
	// 透過建構式設定飲料的描述，description是super class的變數
	public DarkRoast() {
		description = "DarkRoast";
	}
	
	// 計算價格時，直接將DarkRoast價格傳回即可
	public double cost() {
		return .99;
	}

}
