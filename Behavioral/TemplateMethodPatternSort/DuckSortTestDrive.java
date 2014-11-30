package TemplateMethodPatternSort;

import java.util.Arrays;
import java.util.TreeMap;

public class DuckSortTestDrive {
	public static void main(String[] args) {
		// 鴨子陣列
		Duck[] ducks = { 
				new Duck("Daffy", 8), 
				new Duck("Dewey", 2),
				new Duck("Howard", 7),
				new Duck("Louie", 2),
				new Duck("Donald", 10), 
				new Duck("Huey", 2)
		};
		
		System.out.println("Before sorting: ");
		// 印出鴨子陣列名字與體重
		display(ducks);
		
		// 物件陣列排序
		// Array.sort靜態方法會呼叫mergeSort此TemplateMethod...
		// 必須實踐compareTo方法，此方法定義在Compare介面中
		// 所以鴨子類別必須實踐Compare介面
		Arrays.sort(ducks);
		
		System.out.println("\nAfter sorting: ");
		display(ducks);
		
	}
	
	public static void display(Duck[] ducks) {
		for (int i = 0; i < ducks.length; i++) {
			System.out.println(ducks[i]);
		}
	}
}
