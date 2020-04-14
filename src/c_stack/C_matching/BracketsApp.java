package c_stack.C_matching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ∆•≈‰
 * @author Administrator
 *
 */
public class BracketsApp {
	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.println("Enter a String");
			System.out.flush();
			input = getString();
			if ("".equals(input)) {
				break;
			}
			BracketChecker bracketChecker = new BracketChecker(input);
			bracketChecker.check();
		}

	}

	public static String getString() throws IOException {
		String s = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		return s;
	}
}
