package IteratorPatternManuItem;

// 改使用java.util.Iterator
import java.util.Iterator;

// 實踐Menu
public class DinerMenu implements Menu {
	// 控制菜單長度
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	// 使用陣列儲存菜單項目，取出時不需轉型
	MenuItem[] menuItems;
  
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
 
		addItem("Vegetarian BLT",
			"(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
		addItem("BLT",
			"Bacon with lettuce & tomato on whole wheat", false, 2.99);
		addItem("Soup of the day",
			"Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog",
			"A hot dog, with saurkraut, relish, onions, topped with cheese",
			false, 3.05);
		addItem("Steamed Veggies and Brown Rice",
			"Steamed vegetables over brown rice", true, 3.99);
		addItem("Pasta",
			"Spaghetti with Marinara Sauce, and a slice of sourdough bread",
			true, 3.89);
	}
	// 建構式建立菜單
	public void addItem(String name, String description, 
	                     boolean vegetarian, double price) 
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		// 檢查陣列長度是否超過限制
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, menu is full!  Can't add item to menu");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	// 傳回菜單項目的清單(陣列)
	// 不再使用此方法，會把內部實踐方是暴露在外
/*	public MenuItem[] getMenuItems() {
		return menuItems;
	}*/
	// 改由回傳一個Iterator給客戶
	// 客戶不需知道菜單是啥資料結構儲存的，也不需知道反覆器的實踐細節
	// 只需使用此反覆器將菜單項目一一取回
	public Iterator createIterator() {
		// 建構子傳入陣列
		return new DinerMenuIterator(menuItems);
	}
 
	// other menu methods here
}
