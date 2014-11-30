package ObserverPattern;

public class WeatherStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData );
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.notifyObservers();
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.notifyObservers();
		weatherData.setMeasurements(78, 90, 29.2f);
		weatherData.notifyObservers();
	}

}
