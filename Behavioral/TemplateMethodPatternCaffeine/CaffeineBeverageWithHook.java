package TemplateMethodPatternCaffeine;

public abstract class CaffeineBeverageWithHook {
 
	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		// 加調味料前會先透過掛勾方法詢問
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}
 
	abstract void brew();
 
	abstract void addCondiments();
 
	void boilWater() {
		System.out.println("Boiling water");
	}
 
	void pourInCup() {
		System.out.println("Pouring into cup");
	}
 
	// 掛勾(hook)方法：不做事或有預設實踐方式的具象方法，視情況是否由子類別Override
	boolean customerWantsCondiments() {
		return true;
	}
}
