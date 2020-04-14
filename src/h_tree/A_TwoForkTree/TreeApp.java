package h_tree.A_TwoForkTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ������Ӧ��
 */
public class TreeApp {
	public static void main(String[] args) throws IOException {
		int value;
		Tree theTree = new Tree();
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);

		while (true) {
			System.out.println("������Ҫ��ʾ�ĵ�һ����ĸ");
			System.out.println("insert,find,delete,or traverse");
			int choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.println("������Ҫ�����ֵ");
				value = getInt();
				theTree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.println("������Ҫ��ѯ��ֵ");
				value = getInt();
				Node found = theTree.find(value);
				if (found != null) {
					found.displayNode();
					System.out.println();
				} else {
					System.out.println("û��" + value);
				}
				break;
			case 'd':
				System.out.println("Enter value to delete");
				value = getInt();
				boolean didDelete = theTree.delete(value);
				if (didDelete) {
					System.out.println("ɾ���ɹ�");
				} else {
					System.out.println("û�ҵ�Ҫɾ����ֵ");
				}
				break;
			case 't':
				System.out.println("������Ҫ��ѯ������");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.println("��Ч����");
			}

		}

	}

	private static String getString() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	private static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	private static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);

	}
}
