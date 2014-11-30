package IteratorPatternManuItem;

//女侍改使用java.util.Iterator
import java.util.Iterator;

public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	// 新增咖啡廳菜單
	Menu cafeMenu;
 
	// 建構式中，女侍需要傳入兩種菜單
	// 具象菜單類別改成抽象Memu介面(依賴抽象)
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}
	
	// 建立一個printMenu方法，傳入反覆器並列印
	private void printMenu(Iterator iterator) {
		// 檢查是否還有下個元素
		while(iterator.hasNext()) {
			// 取得下個元素
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	// 印出菜單上每個項目
	public void printMenu() {
		// 各自為一種菜單建立一個反覆器
		Iterator pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
		Iterator dinerMenuIterator = dinerMenu.createIterator();
		// 新增咖啡廳菜單反覆器
		Iterator cafeMenuIterator = cafeMenu.createIterator();
		
		System.out.println("MENU\n----\nBREAKFAST");
		// 呼叫overload function printMenu
		printMenu(pancakeHouseMenuIterator);
		
		System.out.println("\nLUNCH");
		printMenu(dinerMenuIterator);
		
		System.out.println("\nDINNER");
		printMenu(cafeMenuIterator);
	}
 
	// 印出早餐項目
	public void printBreakfastMenu(Iterator iterator) {
		System.out.println("\nBREAKFAST");
		printMenu(iterator);
	}
	
	// 印出午餐項目
	public void printLunchMenu(Iterator iterator) {
		System.out.println("\nLUNCH");
		printMenu(iterator);
	}
	
	// 印出所有素食菜單項目
	public void printVegetarianMenu() {
		
	}
	
	// 指定項目名稱，如果是素食傳回true
	private boolean isVegetarian(String name) {
		return false;
	}
}
