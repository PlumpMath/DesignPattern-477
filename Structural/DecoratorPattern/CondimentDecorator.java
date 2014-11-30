package DecoratorPattern;

// 要讓CondimentDecorator取代Beverage，所以要繼承自Beverage
public abstract class CondimentDecorator extends Beverage {
	// why?
	public abstract String getDescription();
}
