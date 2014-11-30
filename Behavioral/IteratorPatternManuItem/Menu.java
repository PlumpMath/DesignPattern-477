package IteratorPatternManuItem;

import java.util.Iterator;

// 提供一個簡單的介面，讓客戶能夠取得一個反覆器，得知菜單內的項目
public interface Menu {
	public Iterator createIterator();
}
