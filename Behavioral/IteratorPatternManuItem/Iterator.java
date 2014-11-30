package IteratorPatternManuItem;

// 反覆器介面，用來反覆取得Collection的每個元素
public interface Iterator {
	// 檢查是否還有更多元素
	boolean hasNext();
	
	// 取得下一個元素
	Object next();
}
