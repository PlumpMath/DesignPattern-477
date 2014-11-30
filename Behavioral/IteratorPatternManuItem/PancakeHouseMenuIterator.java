package IteratorPatternManuItem;

import java.util.ArrayList;

// 實踐反覆器
public class PancakeHouseMenuIterator implements Iterator {
	// 菜單項目ArrayList
	ArrayList items;
	// 記錄當前陣列位置
	int position = 0;
	
	// 建構子傳入一個菜單項目陣列
	public PancakeHouseMenuIterator (ArrayList items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		// 檢查是否超過ArrayList長度，或下一個元素是null
		if (position >= items.size() || items.get(position) == null) {
			return false;
		} else {
			return true;
		} 
	}

	@Override
	public Object next() {
		// 傳回陣列下一個元素
		MenuItem manuItem = (MenuItem) items.get(position);
		// 位置+1
		position ++;
		return manuItem;
	}

}
