package SimpleFactory;

public class SimpleFactory {
	public static Shape createProduct(String product) {
		
/*		if(product.equals("circle")) {
			return new Circle();
		} else if(product.equals("square")) {
			return new Square();
		} else {
			System.out.println("本工廠不生產此產品");
			return null;
		}*/
		
		// 透過Java Reflection改寫
		/*
		 * 為了妥善使用有限的資源，Java 在真正需要使用到 class 的時候才會將其載入，
		 * 當每一個 class 被載入時，JVM 就會為其自動產生一個 Class object。
		 * 
		 * 【註】每一個 class 載入僅會有一個 Class object。
		 * 因此即使使用同一個 class 產生多次 object，也只會有一個與其對應 Class object。
		 * 
		 * 若要動態載入類別，可以使用 Class 類別中的 forName() method，此為 static method，
		 * 因此可以直接透過 Class 類別使用；
		 * 另外，若要取得類別的 instance，可使用 Class 類別中的 newInstance() method
		 * 
		 * 每當 Java 程式啟動後，會有以下三種 Class Loader 進行載入 Class 的工作：
		 * Bootstrap Loader
		 * 搜尋 JRE 目錄($JAVA_HOME/jre/)中的 class 以及 lib 資料夾中的 *.jar 檔，檢查是否有指定的 class 需要載入。
		 * 
		 * ExtClassLoader
		 * 搜尋 JRE 目錄($JAVA_HOME/jre/)中的 lib/ext 資料夾，檢查其中的 class 與 *.jat 檔案，是否有指定的 class 需要載入。
		 * 
		 * AppClassLoader
		 * 搜尋 classpath 中是否有指定的 class 需要載入。
		 */
        try {
            return (Shape) Class.forName(product).newInstance();
        }
        catch(Exception e) {
            System.out.println("本工廠不生產此產品");
            return null;
        }

	}
}
