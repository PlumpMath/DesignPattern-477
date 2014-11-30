package IteratorPatternManuItem;

import java.util.*;
import java.util.Iterator;

//實踐Menu
public class CafeMenu implements Menu {
	// 用Hashtable儲存菜單
	Hashtable menuItems = new Hashtable();
  
	public CafeMenu() {
		addItem("Veggie Burger and Air Fries",
			"Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
			true, 3.99);
		addItem("Soup of the day",
			"A cup of the soup of the day, with a side salad",
			false, 3.69);
		addItem("Burrito",
			"A large burrito, with whole pinto beans, salsa, guacamole",
			true, 4.29);
	}
 
	// 透過此方法建立新菜單，並放入Hashtable中
	public void addItem(String name, String description, 
	                     boolean vegetarian, double price) 
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		// 項目名稱當Key，菜單項目當value
		menuItems.put(menuItem.getName(), menuItem);
	}
 
	// 傳回菜單項目的清單(Hashtable)
	// 不再使用此方法，會把內部實踐方是暴露在外
/*	public Hashtable getItems() {
		return menuItems;
	}
*/
	
	// 改由回傳一個Iterator給客戶
	// 客戶不需知道菜單是啥資料結構儲存的，也不需知道反覆器的實踐細節
	// 只需使用此反覆器將菜單項目一一取回
	public Iterator createIterator() {
		// 取得值的部分的反覆器
		return menuItems.values().iterator();
	}
  
}
