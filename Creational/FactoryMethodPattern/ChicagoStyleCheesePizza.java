package FactoryMethodPattern;

public class ChicagoStyleCheesePizza extends Pizza {
	// 建構子初始化複寫抽象父類別Pizza定義的屬性與方法
	public ChicagoStyleCheesePizza() { 
		// 芝加哥風味的披薩
		name = "Chicago Style Deep Dish Cheese Pizza";
		// 厚皮
		dough = "Extra Thin Crust Dough";
		// 小番茄醬
		sauce = "Plum Tomato Sauce";
		// 用很多義大利白乾酪
		toppings.add("Shredded Mozzarella Cheese");
	}
	// 芝加哥風味披薩cut()方法，將披薩切成正方形
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
