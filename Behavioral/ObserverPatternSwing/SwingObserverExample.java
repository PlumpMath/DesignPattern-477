package ObserverPatternSwing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	JFrame frame;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}

	public void go() {
		frame = new JFrame();
		// button為Subject
		JButton button = new JButton("Shout I do it?");
		button.addActionListener(new AngleListener());
		button.addActionListener(new DevilListener());
		// 設定Frame屬性
		frame.getContentPane().add(BorderLayout.CENTER, button);
	}
	
	// 透過inner class定義觀察者
	class AngleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Don't do it, you might regret it !!");
		}
	} 
	
	class DevilListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Come on, do it.");
		}
	}
}
