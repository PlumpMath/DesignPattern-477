package Composite_IteratorPattern;
 
import java.util.*;

// 實踐java.util.Iterator 介面
public class CompositeIterator implements Iterator {
	Stack stack = new Stack();
	// 將欲造訪的最上層合成節點的反覆器，當作建構子參數丟進堆疊中
	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}
	// 取得下一個元素
	public Object next() {
		// hasNext檢查是否有下一個元素
		if (hasNext()) {
			// 若有下一個元素，取得目前反覆器，取得下一個元素
			Iterator iterator = (Iterator) stack.peek();
			MenuComponent component = (MenuComponent) iterator.next();
			// 若元素是一個菜單(合成節點)，就丟到堆疊中
			if (component instanceof Menu) {
				stack.push(component.createIterator());
			} 
			return component;
		} else {
			return null;
		}
	}
	// 檢查是否還有下一個元素
	public boolean hasNext() {
		// 若stack為空，無下一個元素
		if (stack.empty()) {
			return false;
		} else {
			// 不為空，先取出stack最上層的反覆器，看看是否還有下一個元素
			Iterator iterator = (Iterator) stack.peek();
			// 若沒有元素，取出堆疊，遞迴呼叫hasNext()
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
   
	public void remove() {
		throw new UnsupportedOperationException();
	}
}


