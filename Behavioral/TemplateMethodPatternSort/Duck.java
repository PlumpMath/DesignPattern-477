package TemplateMethodPatternSort;

// 必須讓鴨子類別實踐Comparable介面，因為無法讓鴨子陣列去繼承陣列
public class Duck implements Comparable {
	String name;
	int weight;
  
	// 鴨子有名字與體重
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
 
	public String toString() {
		return name + " weighs " + weight;
	}
 
 
  
	/**
	 * 排序時使用到的方法，compareTo需要傳進另一隻鴨子與本身這隻鴨子比
	 */
	public int compareTo(Object object) {
 
		Duck otherDuck = (Duck)object;
  
		if (this.weight < otherDuck.weight) {
			return -1;
		} else if (this.weight == otherDuck.weight) {
			return 0;
		} else { // this.weight > otherDuck.weight
			return 1;
		}
	}
}
