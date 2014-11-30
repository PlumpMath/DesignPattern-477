package DecoratorPattern;

enum SIZE {
	TALL, GRANDE, VENTI
}

// 飲料是一個抽象類別
public abstract class Beverage {
	
	SIZE size;
	
	String description = "Unknown Beverage";
	
	// getDescription已經在super class實踐
	public String getDescription() {
		return description;
	}
	
	// cost須在sub class實踐
	public abstract double cost();
	
	public void setSize(SIZE size) {
		this.size = size;
	}
	
	public SIZE getSize() {
		return size;
	}
}
