package AdapterPatternIterenum;

import java.util.*;

// 將Enumeration介面轉成Iterator介面
public class EnumerationIterator implements Iterator {
	// 被轉接者
	Enumeration enumeration;
	
	public EnumerationIterator(Enumeration enumeration) {
		this.enumeration = enumeration;
	}
	
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}

	// 由於無法透過Enumeration實作remove方法，所以丟出例外
	// Notice: 轉接器未完美的地方，無法實作時，必須小心處理例外
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	 
}
