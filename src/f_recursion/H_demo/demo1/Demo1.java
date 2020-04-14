package f_recursion.H_demo.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 递归求一个数的乘方
 * 
 * @author Administrator
 * 
 */
public class Demo1 {
	static long theAnswer = 1;
	static long count = 1;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		System.out.println("数：");
		long num = getInt();
		System.out.println("阶层：");
		long rank = getInt();
		power(num, rank);
		System.out.println(theAnswer);
	}

	private static void power(long num, long rank) {
		if (rank == 1) {
			return;
		} else {
			if (rank % 2 != 0) {
				count *= num;
			}
			rank = rank / 2;
			theAnswer = num * num;
			power(theAnswer, rank);
			theAnswer *= count;
		}

	}

	public static int getInt() throws NumberFormatException, IOException {
		return Integer.parseInt(getString());
	}

	private static String getString() throws IOException {

		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
}
