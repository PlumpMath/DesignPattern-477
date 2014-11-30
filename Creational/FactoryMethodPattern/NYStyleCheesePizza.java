package FactoryMethodPattern;

public class NYStyleCheesePizza extends Pizza {
	// 建構子初始化複寫抽象父類別Pizza定義的屬性與方法
	public NYStyleCheesePizza() { 
		// 紐約風味的披薩
		name = "NY Style Sauce and Cheese Pizza";
		// 薄皮
		dough = "Thin Crust Dough";
		// 大蒜番茄醬
		sauce = "Marinara Sauce";
		// 帕達及安偌乳酪
		toppings.add("Grated Reggiano Cheese");
	}
}
