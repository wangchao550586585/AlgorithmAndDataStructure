 package i_hash.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * hash��
 * 
 * @author Administrator
 *
 */
public class HashTableApp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		DataItem aDataItem;
		int size, n, keysPerCell, aKey;
		System.out.print("Enter size of hash table : ");// �������ϣ��Ĵ�С
		size = getInt();// ��ʼ����ϣ���С
		System.out.print("Enter initial number of items : ");// �������ʼ��Ŀ
		n = getInt();// ��ʼ����ϣ��������Ŀ
		// make table
		HashTable theHashTable = new HashTable(size);
		keysPerCell = 10;
		// ��������
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);// �����ֵ
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		while (true) {
			System.out.print("�������һ����ĸ : ");
			System.out.print("show,insert,delete,or find : ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("������Ҫ���������:");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.println("������Ҫɾ��������:");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.println("������Ҫ��ѯ������:");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null) {
					System.out.println("�ҵ�����" + aKey);
				} else {
					System.out.println("û�ҵ�����" + aKey);
				}
				break;
			default:
				System.out.print("��Ч����");
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
