package i_hash.B_hashDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ʹ���ڹ�ϣ���洢����
 * 
 * @author Administrator
 * 
 */
public class HashDoubleApp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int size, n, aKey;
		DataItem aDataItem;
		System.out.print("��ָ����ϣ��Ĵ�С: ");
		size = getInt();
		System.out.print("ָ����ϣ���ʼ����������");
		n = getInt();
		HashTable theHashTable = new HashTable(size);
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * 2 * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aKey, aDataItem);
		}
		while (true) {
			System.out.print("�������һ����ĸ��");
			System.out.println("find,insert,show or delete");
			char choice = getChar();
			switch (choice) {
			case 'i':
				System.out.print("������Ҫ�����ֵ: ");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aKey, aDataItem);
				break;
			case 's':
				theHashTable.display();
				break;
			case 'f':
				System.out.print("������Ҫ��ѯ��ֵ: ");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null) {
					System.out.println("�ҵ�ֵ��" + aKey);
				} else {
					System.out.println("û���ҵ�ֵ��" + aKey);
				}
				break;
			case 'd':
				System.out.println("������Ҫɾ����ֵ��");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;

			default:
				System.out.println("��Ч���룡����");
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
