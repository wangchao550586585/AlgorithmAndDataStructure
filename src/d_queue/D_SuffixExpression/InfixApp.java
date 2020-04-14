package d_queue.D_SuffixExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 解析算数表达式：后缀表达式
 * @author Administrator
 *
 */
public class InfixApp {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter infix:");
			System.out.flush();
			input=getString();
			if(input.equals(""))break;
			IntoPost theIntoPost=new IntoPost(input);
			output=theIntoPost.doTrans();
			System.out.println("Postfix is "+output);
		}
	}

	public static String getString() throws IOException {
		String s = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		return s;
	}
}
