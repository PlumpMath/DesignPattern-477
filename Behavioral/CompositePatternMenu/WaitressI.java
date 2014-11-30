package CompositePatternMenu;

//女侍改使用java.util.Iterator
import java.util.ArrayList;
import java.util.Iterator;

public class WaitressI {
	ArrayList menus;
	
	// 具象菜單類別改成抽象Memu介面(依賴抽象)
	// 違反OCP，將菜單全部包裝成ArrayList再傳入
	public WaitressI(ArrayList menus) {
		// 只接受ArrayList型別參數，內部元素全是菜單
		this.menus = menus;
	}
	
	// 建立一個printMenu方法，傳入反覆器並列印
	private void printMenu(Iterator iterator) {
		// 檢查是否還有下個元素
		while(iterator.hasNext()) {
			// 取得下個元素
			MenuItemI menuItem = (MenuItemI) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	// 印出菜單上每個項目
	public void printMenu() {
		Iterator menuIterator = menus.iterator();
		// 反覆遊走菜單，並將菜單反覆器傳給printMenu方法
		while(menuIterator.hasNext()) {
			MenuI menu = (MenuI) menuIterator.next();
			printMenu(menu.createIterator());
		}
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
