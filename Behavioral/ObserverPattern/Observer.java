package ObserverPattern;

public interface Observer {
	// 氣象數據改變時，主題會把這些狀態值當參數傳給觀察者
	public void update(float temp,float humidity, float pressure);
}
