package e_link.I_Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����ʵ�ֵ�����
 * 
 * @author Administrator
 *
 */
public class InterIterApp {
	public static void main(String[] args) throws IOException {
		LinkList theList = new LinkList();
		ListIterator iterator = theList.getIterator();
		long value;

		iterator.insertAfter(20);
		iterator.insertAfter(30);
		iterator.insertAfter(40);
		iterator.insertAfter(50);
		iterator.insertBefore(60);

		while (true) {
			int cho = getChar();
			switch (cho) {
			case 's':// ����
				if (!theList.isEmpty())
					theList.displayList();
				else
					System.out.println("List is empty");
				break;
			case 'r':// ��������λ�����ڱ�ͷ
				iterator.reset();
				break;
			case 'n':// ��һ�����ӵ�
				if (!theList.isEmpty() && !iterator.atEnd())
					iterator.nextLink();
				else
					System.out.println("����ȥ��һ������");
				break;
			case 'g':// ��ȡ��ǰ����
				if (!theList.isEmpty()) {
					value = iterator.getCurrent().dData;
					System.out.println(value);
				} else
					System.out.println("����Ϊ��");
				break;
			case 'b': // �����ӵ�ǰ����������ӵ�
				value = getInt();
				iterator.insertBefore(value);
				break;
			case 'a': // �����ӵ������������ӵ�
				value = getInt();
				iterator.insertAfter(value);
				break;
			case 'd': // ɾ����ǰ
				if (!theList.isEmpty()) {
					value = iterator.deleteCurrent();
					System.out.println(value);
				} else
					System.out.println("����ɾ��");
				break;
			default:
				System.out.println("Invalid entry");// ��Ч
			}
		}
	}

	/*
	 * ���ؿ���̨������ַ�
	 */
	public static String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return s;
	}

	private static int getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	private static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

}
