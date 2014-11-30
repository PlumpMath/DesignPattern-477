package ObserverPattern;

public interface Subject {
	// 註冊觀察者
	public void registerObserver(Observer o);
	// 移除觀察者
	public void removeObserver(Observer o);
	// 主題狀態改變時，此方法會被呼叫，以通知所有的觀察者
	public void notifyObservers(); 
}
