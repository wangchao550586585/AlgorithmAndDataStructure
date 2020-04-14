package h_tree.B_tree234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 234��Ӧ��
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
			System.out.println("������ִ�в����ĵ�һ����ĸ��");
			System.out.println(" show , insert ,or find");
			char choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();

				break;
			case 'i':
				System.out.println("������Ҫ������ַ���");
				value = getInt();
				theTree.insert(value);
				break;
			case 'f':
				System.out.println("������Ҫ��ѯ�����֣�");
				value = getInt();
				int found = theTree.find(value);
				if (found == -1) {
					System.out.println("û���ҵ�");
				} else {
					System.out.println("�ҵ�");
				}
				break;
			default:
				System.out.println("������������ַ�");

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
