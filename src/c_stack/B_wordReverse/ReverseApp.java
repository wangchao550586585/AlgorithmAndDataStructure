package c_stack.B_wordReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * µ¥´ÊÄæÐò
 * 
 * @author Administrator
 *
 */
public class ReverseApp {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.println("Enter a String");
			System.out.flush();
			input = getString();
			if (("").equals(input)) {
				break;
			}
			Reverser reverser = new Reverser(input);
			output = reverser.doRev();
			System.out.println("Reversed:" + output);
		}
	}

	public static String getString() throws IOException {
		String s = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		return s;
	}

}
