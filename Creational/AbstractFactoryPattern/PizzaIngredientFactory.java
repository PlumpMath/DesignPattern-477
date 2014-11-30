package AbstractFactoryPattern;

public interface PizzaIngredientFactory {
	// 每一種原料都有對應方法建立該原料
	// 由次類別決定(實踐)要建立何種原料
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
