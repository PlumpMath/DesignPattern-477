package CompositePatternMenu;

import java.util.Iterator;
  
// 女侍只需依賴MenuComponent介面
public class Waitress {
	// 最上層菜單
	MenuComponent allMenus;
 
	// 只須給女侍最上層菜單
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
 
	//只需呼叫最上層菜單的print()就可印出整個菜單層級
	public void printMenu() {
		allMenus.print();
	}
}
