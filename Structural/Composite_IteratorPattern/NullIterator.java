package Composite_IteratorPattern;

import java.util.Iterator;
// for 菜單項目使用
public class NullIterator implements Iterator {

	// hasNext()被呼叫時，永遠回傳false
	@Override
	public boolean hasNext() {
		return false;
	}

	// next()回傳null
	@Override
	public Object next() {
		return null;
	}

	// 菜單項目iterator不支援remove
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
