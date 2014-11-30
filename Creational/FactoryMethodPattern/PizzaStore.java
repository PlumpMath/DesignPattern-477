package FactoryMethodPattern;

public abstract class PizzaStore {
	// orderPizza為超類別的方法
	public Pizza orderPizza(String type) {
		Pizza pizza;
		// 由PizzaStore subClass的方法來處理物件實體化
		pizza = createPizza(type);
		 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	// 實體化Pizza的責任被移到一個方法，就像是一個工廠
	// 工廠方法是一個抽象方法，依賴次類別負責物件的建立
	protected abstract Pizza createPizza(String type);
}
