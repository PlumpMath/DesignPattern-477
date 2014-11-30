package CompositePatternMenu;

/** 菜單元件抽象類別提供一個共同介面，讓葉節點與合成節點共同繼承
 * 	  先提供預設實踐方式，若葉節點或合成節點不想實踐時可以不需實踐這些方法
 * @author boki
 */
public abstract class MenuComponent {
	/*有些方法只對MenuItem有意義，有些對Menu有意義
	 * 所以方法預設都是丟出UnsupportedOperationException
	 * 如果不支援MenuItem或Menu不支援某方法時，只需使用繼承來的預設方法
	 */
	
	// 增加子節點(與合成節點有關)
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	// 刪除子節點(與合成節點有關)
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	// 取得子節點(與合成節點有關)
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
    // 取得菜單名稱(與葉節點相關)
	public String getName() {
		throw new UnsupportedOperationException();
	}
    // 取得菜單描述(與葉節點相關)
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
    // 取得菜單價格(與葉節點相關)
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
    // 是否為素食(與葉節點相關)
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}
	// 一個操作方法，葉節點與合成節點都實踐
	public void print() {
		throw new UnsupportedOperationException();
	}
}
