package d_queue.E_SuffixExpressionValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 运算后缀表达式
 * 
 * @author Administrator
 *
 */
public class InfixApp {
	public static void main(String[] args) throws IOException {
		String input;
		int output;
		while (true) {
			System.out.print("Enter infix:");
			System.out.flush();
			input = getString();
			if (input.equals(""))
				break;
			ParsePost theParse = new ParsePost(input);
			output = theParse.doTrans();
			System.out.println("Postfix is " + output);
		}
	}

	public static String getString() throws IOException {
		String s = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		return s;
	}
}
