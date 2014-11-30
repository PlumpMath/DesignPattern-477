package SimpleFactory;

/**
 * @author boki
 * Simple Factory模式又稱Static Factory模式。
 * 一個Simple Factory生產成品，而對客戶端隱藏產品產生的細節，物件如何生成，
 * 生成前是否與其它物件建立依賴關係，客戶端皆不用理會，用以將物件生成方式之變化與客戶端程式碼隔離。
 * 
 * 簡單工廠模式（又稱靜態工廠模式）的概念很簡單，稍微瞭解物件導向中「多型」（polymorphism）的人來說，
 * 可能;就或多或少會使用到簡單工廠模式的概念。
 * 假設我們要在程式中產生兩個物件：一個圓形與一個方形。它們會負責畫出自己，
 * 我們可以設計一個簡單的工廠類別，這個類別會專門負責製作各種形狀之物件，並擁有上面所提及之功能。
 * 
 */
public class Main {
	public static void main(String args[]) {
		// 產生一個圓形並秀出它
		//SimpleFactory.createProduct("circle").draw();
		//System.out.println();
		// 產生一個方形並秀出它
		//SimpleFactory.createProduct("square").draw();
		
		// 透過Java Reflection改寫 (須指定package及物件)
		SimpleFactory.createProduct("SimpleFactory.Circle").draw();
		SimpleFactory.createProduct("SimpleFactory.Square").draw();
	}
}
