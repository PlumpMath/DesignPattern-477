package IteratorPatternManuItem;

// 改使用java.util.Iterator
import java.util.Iterator;

// 實踐反覆器
public class DinerMenuIterator implements Iterator {
	// 菜單項目陣列
	MenuItem[] items;
	// 記錄當前陣列位置
	int position = 0;
	
	// 建構子傳入一個菜單項目陣列
	public DinerMenuIterator (MenuItem[] items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		// 檢查是否超過陣列長度，或下一個元素是null
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		} 
	}

	@Override
	public Object next() {
		// 傳回陣列下一個元素
		MenuItem manuItem = items[position];
		// 位置+1
		position ++;
		return manuItem;
	}

	// 必須實踐remove
	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException
				("You can't remove an item until you've done at least one next()");
		}
		// 將被刪除的物件之後每一個物件都往前移動一個位置
		if (items[position-1] != null) {
			for (int i = position-1; i < (items.length-1); i++) {
				items[i] = items[i+1];
			}
			items[items.length-1] = null;
		}
	}

}
