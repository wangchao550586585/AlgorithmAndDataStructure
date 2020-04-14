package f_recursion.G_stackTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ջ����Ӧ��
 * �ݹ�ʵ��ջת��
 * @author Administrator
 *
 */
public class StackTriangleApp {
	static int theNumber;// ����ֵ
	static int theAnswer;// ��
	static StackX theStackx;// ջ
	static int codePart;// case����
	static Params theseParams;// ����

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
		case 1:// ��ʼ����
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
		case 3://��ջ����
			Params newParams = new Params(theseParams.n - 1, 4);
			theStackx.push(newParams);
			codePart = 2;
			break;
		case 4:// ����
			theseParams = theStackx.peek();
			theAnswer = theAnswer + theseParams.n;
			codePart = 5;
			break;
		case 5://�˳�����
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
