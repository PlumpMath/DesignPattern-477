package AbstractFactoryPattern;

public class CheesePizza extends Pizza {
	// 建立一個工廠實體變數(Reference)
	PizzaIngredientFactory ingredientFactory;
	// 透過建構子參數得到一個工廠
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		// 每當需要原料時，就跟工廠要(Polymorphism)
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
