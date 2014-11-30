package Composite_IteratorPattern;

import java.util.Iterator;
  
public class Waitress {
	MenuComponent allMenus;
 
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
 
	public void printMenu() {
		allMenus.print();
	}
  
	// 印出素食菜單
	public void printVegetarianMenu() {
		// 取得allMenus的反覆器
		Iterator iterator = allMenus.createIterator();

		System.out.println("\nVEGETARIAN MENU\n----");
		
		// 遊走合成的每個元件
		while (iterator.hasNext()) {
			MenuComponent menuComponent = 
					(MenuComponent)iterator.next();
			try {
				// 若菜單是素食才印
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {}
		}
	}
}
