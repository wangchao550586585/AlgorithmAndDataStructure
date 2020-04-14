package h_tree.B_tree234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 234树应用
 * 
 * @author Administrator
 *
 */
public class Tree234App {
	public static void main(String[] args) throws IOException {
		Tree234 theTree = new Tree234();
		theTree.insert(10);
		theTree.insert(90);
		theTree.insert(30);
		theTree.insert(75);
		theTree.insert(36);

		int value;
		while (true) {
			System.out.println("请输入执行操作的第一个字母：");
			System.out.println(" show , insert ,or find");
			char choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();

				break;
			case 'i':
				System.out.println("请输入要插入的字符：");
				value = getInt();
				theTree.insert(value);
				break;
			case 'f':
				System.out.println("请输入要查询的数字：");
				value = getInt();
				int found = theTree.find(value);
				if (found == -1) {
					System.out.println("没有找到");
				} else {
					System.out.println("找到");
				}
				break;
			default:
				System.out.println("输入无意义的字符");

			}
		}

	}

	private static char getChar() throws IOException {

		return getString().charAt(0);
	}

	private static String getString() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	private static int getInt() throws NumberFormatException, IOException {

		return Integer.parseInt(getString());
	}
}
