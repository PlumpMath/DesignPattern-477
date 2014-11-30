package ObserverPattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	// 建構式需要weatherData物件(Subject)，以註冊之用
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	// 佈告版將溫度、濕度顯示出來
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degree and "
				+ humidity + "% humidity");
	}

}
