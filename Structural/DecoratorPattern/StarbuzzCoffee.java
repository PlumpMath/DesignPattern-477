package DecoratorPattern;

public class StarbuzzCoffee {

	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		
		// 產生一個DarkRoast物件(被裝飾者)
		Beverage beverage2 = new DarkRoast();
		// 用Mocha裝飾它
		beverage2 = new Mocha(beverage2);
		// 用Mocha裝飾它
		beverage2 = new Mocha(beverage2);
		// 用Whip裝飾它
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		
		Beverage beverage3 = new HouseBlend();
		//beverage3 = new Soy(beverage3);
		// 先後順序會影響到小數點後XX位?
		beverage3 = new Milk(beverage3);
		beverage3 = new Mocha(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
		
		Beverage beverage4 = new DarkRoast();
		beverage4.setSize(SIZE.VENTI);
		beverage4 = new Soy(beverage4);
		
		System.out.println(beverage4.getDescription() + " $" + beverage4.cost());
	}

}
