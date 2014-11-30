package ObserverPatternByJava;

import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Observable observable;
	
	// 建構式需要observable物件(Observable)，以註冊之用
	public HeatIndexDisplay(Observable observable) {
		this.observable = observable;
		// 呼叫addObserver註冊；呼叫deleteObserver刪除觀察者
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Heat index is " + computeHeatIndex(temperature,humidity));
	}

	 private float computeHeatIndex(float t, float rh) {
	        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
	            (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
	            (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
	            (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *  
	            (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
	            (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +     
	            0.000000000843296 * (t * t * rh * rh * rh)) -
	            (0.0000000000481975 * (t * t * t * rh * rh * rh)));
	        return index;
	    }

	/**觀察者接收通知
	 * @param Observable weatherData 主題本身，好讓觀察者知道是哪個主題通知他
	 * @param Object arg 傳送任何物件資料給每一個觀察者 
	 */
	@Override
	public void update(Observable obs, Object arg) {
		// 先確定可觀察者是WeatherData型態，才透過get(pull)方式取得資料
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
}
