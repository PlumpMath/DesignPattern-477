package Composite_IteratorPattern;

import java.util.Iterator;
import java.util.ArrayList;

public class Menu extends MenuComponent {
	// Menu可以有任意數目子類別(只要屬於MenuComponent型態)，並使用ArrayList紀錄子類別
	ArrayList menuComponents = new ArrayList();
	String name;
	String description;
	// 將給每一個菜單一個名字與一個描述(與之前實踐方式不同)
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	// 將菜單或菜單項目加入此菜單中(菜單或菜單項目都屬於MenuComponent)
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	// 此菜單中刪除菜單或菜單項目(菜單或菜單項目都屬於MenuComponent)
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	// 取得菜單中的菜單或菜單項目(菜單或菜單項目都屬於MenuComponent) 
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	}
 
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}
 
	public void print() {
		// 印出菜單同時印出菜單名稱及敘述
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
  
		// 印出菜單內所有元件的內容
		// 使用反覆器(ArrayList內建反覆器)，逐一遊走菜單內每個元件
		// 由於菜單及菜單項目都有實踐Print()，只需呼叫Print()即可
		Iterator iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = 
				(MenuComponent)iterator.next();
			menuComponent.print();
		}
	}
	
	// 實踐一個合成的反覆器，為每個元件加上createIterator
	public Iterator createIterator() {
		return new CompositeIterator(menuComponents.iterator());
	}
}
