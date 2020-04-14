package f_recursion.G_stackTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 栈三角应用
 * 递归实现栈转换
 * @author Administrator
 *
 */
public class StackTriangleApp {
	static int theNumber;// 三角值
	static int theAnswer;// 答案
	static StackX theStackx;// 栈
	static int codePart;// case条件
	static Params theseParams;// 参数

	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number: ");
		theNumber = getInt();
		recTriangle();
		System.out.println("Triangle = " + theAnswer);
	}

	private static void recTriangle() {
		theStackx = new StackX(10000);
		codePart = 1;
		while (step() == false) {

		}
	}

	private static boolean step() {
		switch (codePart) {
		case 1:// 初始调用
			theseParams = new Params(theNumber, 6);
			theStackx.push(theseParams);
			codePart = 2;
			break;
		case 2:
			theseParams = theStackx.peek();
			if (theseParams.n == 1) {
				theAnswer = 1;
				codePart = 5;
			} else {
				codePart = 3;
			}
			break;
		case 3://入栈操作
			Params newParams = new Params(theseParams.n - 1, 4);
			theStackx.push(newParams);
			codePart = 2;
			break;
		case 4:// 计算
			theseParams = theStackx.peek();
			theAnswer = theAnswer + theseParams.n;
			codePart = 5;
			break;
		case 5://退出方法
			theseParams = theStackx.peek();
			codePart = theseParams.returnAddress;//4 or 6
			theStackx.pop();
			break;
		case 6:
			return true;
		}
		return false;
	}

	public static int getInt() throws IOException {
		return Integer.parseInt(getSting());
	}

	private static String getSting() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

}
