package f_recursion.G_stackTriangle2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 栈三角应用 
 * 取代stackTriangle2#step()
 * 
 * @author Administrator
 */
public class StackTriangleApp {
	static int theNumber;
	static int theAnswer;
	static StackX theStackX;

	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number: ");
		theNumber = getInt();
		stackTriangle();
		System.out.println("Triangle = " + theAnswer);
	}

	private static void stackTriangle() {
		theStackX = new StackX(100);
		theAnswer = 0;
		while (theNumber > 0) {
			theStackX.push(theNumber);
			--theNumber;
		}
		while (!theStackX.isEmpty()) {
			theAnswer += theStackX.pop();
		}

	}

	public static int getInt() throws IOException {
		return Integer.parseInt(getSting());
	}

	private static String getSting() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

}
