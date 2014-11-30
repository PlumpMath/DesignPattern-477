package TemplateMethodPatternSwingApplet;

import java.applet.Applet;
import java.awt.Graphics;

public class MyApplet extends Applet {
	String message;
	
	// init掛鉤用來進行applet初始化動作，只會執行一次
	public void init() {
		message = "Hello World, I'm alive!";
		// Applet類別的具象方法
		repaint();
	}
	
	// start掛鉤在applet正要被顯示在網頁上時，作一些動作
	public void start() {
		message = "Now I'm starting up...";
		// Applet類別的具象方法
		repaint();
	}
	
	// 使用者跳到別頁面，stop掛鉤就會被呼叫。applet就可以在此作一些動作
	public void stop() {
		message = "Oh, now I'm being stopped...";
		// Applet類別的具象方法
		repaint();
	}
	
	// applet被摧毀時，destroy會被呼叫
	public void destory() {
		
	}
	
	// applet也將paint當掛鉤
	public void paint(Graphics g) {
		g.drawString(message, 5, 15);
	}

}
