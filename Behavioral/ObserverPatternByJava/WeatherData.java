package ObserverPatternByJava;

import java.util.Observable;
import java.util.Observer;

// 繼承java.util.Observable物件(Subject)
public class WeatherData extends Observable {
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	// constructor不需要建立一個collection記住所有觀察者
	public WeatherData() {
	}
	
// 不需追蹤與管理註冊觀察者，通通交給superClass處理
/*	// 註冊觀察者時，只要把它加入ArrayList
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
	}*/

	// 通知觀察者
/*	@Override
	public void notifyObservers() {
		for (int i =0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			// 由於觀察者都實踐Observer介面，只要透過update()即可
			observer.update(temperature, humidity, pressure);
		}
	}*/
	
	public void measurementsChanged() {
		// 標記狀態已改變事實，在呼叫notifyObservers前要
		// 先透過setChanged標記狀態改變，否則觀察者就不會被通知
		setChanged();
		// notifyObservers() : pull
		// notifyObservers(Object args) : push
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.setTemperature(temperature);
		this.setHumidity(humidity);
		this.setPressure(pressure);
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
}
