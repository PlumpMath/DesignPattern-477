package ObserverPattern;

public class StatisticsDisplay implements Observer , DisplayElement {

	private static float sumTemp = 0.0f;
	private static float maxTemperature = 0.0f;
	private static float minTemperature = 200.0f;
	private static float rumReading = 0.0f;
	private Subject weatherData;
	
	// 建構式需要weatherData物件(Subject)，以註冊之用
	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + sumTemp/rumReading + "/"
			+ maxTemperature + "/" + minTemperature);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		sumTemp += temperature;
		rumReading++;
		
		if (temperature > maxTemperature) {
			maxTemperature = temperature;
		}
		
		if (temperature < minTemperature) {
			minTemperature = temperature;
		}
		
		display();
	}

}
