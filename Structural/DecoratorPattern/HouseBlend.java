package DecoratorPattern;

public class HouseBlend extends Beverage {
	// 透過建構式設定飲料的描述，description是super class的變數
	public HouseBlend() {
		description = "HouseBlend";
	}
	
	// 計算價格時，直接將HouseBlend價格傳回即可
	public double cost() {
		return .88;
	}

}
