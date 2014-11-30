package IteratorPatternManuItem;

import java.util.ArrayList;
import java.util.Iterator;

//實踐Menu
public class PancakeHouseMenu implements Menu {
	ArrayList menuItems;
	// 使用ArrayList儲存菜單項目
	public PancakeHouseMenu() {
		menuItems = new ArrayList();
    
		addItem("K&B's Pancake Breakfast", 
			"Pancakes with scrambled eggs, and toast", 
			true,
			2.99);
 
		addItem("Regular Pancake Breakfast", 
			"Pancakes with fried eggs, sausage", 
			false,
			2.99);
 
		addItem("Blueberry Pancakes",
			"Pancakes made with fresh blueberries",
			true,
			3.49);
 
		addItem("Waffles",
			"Waffles, with your choice of blueberries or strawberries",
			true,
			3.59);
	}
	// 菜單建構式，將每一個菜單項目加入ArrayList中
	public void addItem(String name, String description,
	                    boolean vegetarian, double price)
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	// 傳回菜單項目的清單(ArrayList)
	// 不再使用此方法，會把內部實踐方是暴露在外
/*	public ArrayList getMenuItems() {
		return menuItems;
	}*/
	// 改由回傳一個Iterator給客戶
	// 客戶不需知道菜單是啥資料結構儲存的，也不需知道反覆器的實踐細節
	// 只需使用此反覆器將菜單項目一一取回
	public Iterator createIterator() {
		// 建構子傳入ArrayList
		//return new PancakeHouseMenuIterator(menuItems);
		// 改使用java.util.Iterator
		return menuItems.iterator();
	}
	
	public String toString() {
		return "Objectville Pancake House Menu";
	}

	// other menu methods here
}
