package ObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject {
	// 使用ArrayList來記錄觀察者，在建構式中建立
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}
	
	// 註冊觀察者時，只要把它加入ArrayList
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	// 要註冊取消觀察者時，只要從ArrayList移除
	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i > 0) {
			observers.remove(i);
		}
	}

	// 通知觀察者
	@Override
	public void notifyObservers() {
		for (int i =0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			// 由於觀察者都實踐Observer介面，只要透過update()即可
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
}
