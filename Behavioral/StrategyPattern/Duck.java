package StrategyPattern;

public abstract class Duck {
	// 宣告兩個變數行為介面，讓所有鴨子subclass繼承
	// 實現此介面透過Polymorphism 
	// Duck的飛行行為與呱呱叫行為透過Delegate實現
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck() {
		
	}
	
	public abstract void display();
	
	public void performFly() {
		// 動作交由Delegate處理
		flyBehavior.fly();
	}
	
	public void performQuack() {
		// 動作交由Delegate處理
		quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println("All ducks float, even decoys!!");
	}
	
	// 在Duck類別加上set方法設定Duck行為
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}
