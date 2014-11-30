package TemplateMethodPatternSwingApplet;

import java.awt.Graphics;
// JFrame...基本的Swing容器
import javax.swing.JFrame;

// 繼承JFrame具有一個update()方法，包含負責螢幕畫面更新的演算法
// 藉由推翻paint()掛勾方法來和此演算法搭上線
public class MyFrame extends JFrame {
	// 初始化
	public MyFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	// Override掛勾方法
	public void paint(Graphics graphics) {
		super.paint(graphics);
		String msg = "I rule!!";
		graphics.drawString(msg, 150, 150);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			MyFrame myFrame = new MyFrame("Head First Design Pattern");
	}
}
