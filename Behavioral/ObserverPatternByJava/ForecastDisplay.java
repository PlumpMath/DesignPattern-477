package ObserverPatternByJava;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer , DisplayElement {

	private float currentPressure = 29.92f;  
	private float lastPressure;
	private Observable observable;
	
	// 建構式需要observable物件(Observable)，以註冊之用
	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		// 呼叫addObserver註冊；呼叫deleteObserver刪除觀察者
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
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
	        lastPressure = currentPressure;
	        currentPressure = weatherData.getPressure();
			display();
		}
	}

}
