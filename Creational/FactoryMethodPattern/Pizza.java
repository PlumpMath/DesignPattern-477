package FactoryMethodPattern;

import java.util.ArrayList;

// 抽象披薩類別，所有具象披薩都必需繼承此類別
public abstract class Pizza {
	// 披薩名稱
	String name;
	// 麵團型態
	String dough;
	// 醬汁型態
	String sauce;
	// 一組餡料
	ArrayList toppings = new ArrayList();
	
	// 預備動作需要以特定順序，進行一連串步驟
	void prepare() {
		System.out.println("Preparing " + name);
		// 揉麵糰
		System.out.println("Tossing dough...");
		// 加醬汁
		System.out.println("Adding sauce...");
		// 加餡料
		System.out.println("Adding toppings: ");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println("	"+ toppings.get(i));
		}
	}
	
	// 烘焙
	void bake() {
		System.out.println("Bake for 25 mins at 350");
	}
	// 切片
	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
	// 裝箱
	void box() {
		System.out.println("Place pizza in  official PizzaStorebox");
	}
	
	public String getName() {
		return name;
	}
}
