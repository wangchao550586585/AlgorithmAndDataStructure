package i_hash.C_hashChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����ַ��
 * 
 * @author Administrator
 *
 */
public class HashChainApp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int aKey, size, n, keysPerCell = 100;
		Link aDataItem;
		System.out.print("ָ����ϣ��Ĵ�С:");
		size = getInt();
		System.out.print("ָ����ϣ���ʼ��Ŀ:");
		n = getInt();
		HashTable theHashTable = new HashTable(size);
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);
			aDataItem = new Link(aKey);
			theHashTable.insert(aDataItem);
		}
		while (true) {
			System.out.print("�������һ����ĸ��");
			System.out.print("show,find,insert or delete ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("������Ҫ��������ݣ�");
				aKey = getInt();
				aDataItem = new Link(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("������Ҫ��������ݣ�");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("������Ҫ��ѯ������");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null)
					System.out.println("�ҵ�" + aKey);
				else
					System.out.println("����ʧ��" + aKey);
				break;

			default:
				System.out.println("��Ч����");
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
