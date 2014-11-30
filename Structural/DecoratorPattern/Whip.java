package DecoratorPattern;

public class Whip extends CondimentDecorator {
	// 透過實體變數紀錄一個被裝飾者，也就是Beverage物件
	Beverage beverage;
	
	// 透過建構式，Beverage當作參數將Beverage物件紀錄在實體變數中
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	// 透過delegate方式，從被裝飾者得到一個價格再加上附加(配料)價格
	public double cost() {
		return .10 + beverage.cost();
	}

}
