package f_recursion.A_Trangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 三角数字 公式:(n*n+n)/2
 * 
 * @author Administrator
 *
 */
public class Trangle {
	static int theNumber;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		theNumber = getInt();
		int theAnswer = triangle(theNumber);
		System.out.println(theAnswer);
	}

	private static int triangle(int number) {
		if (number == 1)
			return 1;
		else {
			return number + triangle(number - 1);
		}

	}

	private static int getInt() throws NumberFormatException, IOException {

		return Integer.parseInt(getString());
	}

	private static String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
}
