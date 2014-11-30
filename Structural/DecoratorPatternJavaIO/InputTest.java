package DecoratorPatternJavaIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int c;
		try {
			InputStream in = new LowerCaseInputStream(
												new BufferedInputStream(
														new FileInputStream("D:\\JAVA EE\\myWorkSpace\\DesignPattern\\Structural\\DecoratorPatternJavaIO\\test.txt")));
			while ((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
