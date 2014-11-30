package IteratorPatternManuItem;

import java.util.*;

public class MenuTestDrive {
	public static void main(String args[]) {
		// 建立菜單
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        // 建立咖啡廳菜單
        CafeMenu cafeMenu = new CafeMenu();
        
        // 建立女侍，並把菜單傳遞給他
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
		// 女侍列印菜單
		waitress.printMenu();
	}

}
