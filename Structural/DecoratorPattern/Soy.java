package DecoratorPattern;

public class Soy extends CondimentDecorator {
	// 透過實體變數紀錄一個被裝飾者，也就是Beverage物件
	Beverage beverage;
	
	// 透過建構式，Beverage當作參數將Beverage物件紀錄在實體變數中
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public SIZE getSize() {
		return beverage.getSize();
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	// 透過delegate方式，從被裝飾者得到一個價格再加上附加(配料)價格
	public double cost() {
		//return .15 + beverage.cost();
		double cost = beverage.cost();
		if (getSize() == SIZE.TALL) {
			cost += .10;
		} else if (getSize() == SIZE.GRANDE) {
			cost += .15;
		} else if (getSize() == SIZE.VENTI) {
			cost += .20;
		}
		return cost;
	}

}
