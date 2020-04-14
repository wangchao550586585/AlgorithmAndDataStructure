 package i_hash.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * hash表
 * 
 * @author Administrator
 *
 */
public class HashTableApp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		DataItem aDataItem;
		int size, n, keysPerCell, aKey;
		System.out.print("Enter size of hash table : ");// 请输入哈希表的大小
		size = getInt();// 初始化哈希表大小
		System.out.print("Enter initial number of items : ");// 请输入初始数目
		n = getInt();// 初始化哈希表里面数目
		// make table
		HashTable theHashTable = new HashTable(size);
		keysPerCell = 10;
		// 插入数据
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);// 插入的值
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		while (true) {
			System.out.print("请输入第一个字母 : ");
			System.out.print("show,insert,delete,or find : ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("请输入要插入的数据:");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.println("请输入要删除的数据:");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.println("请输入要查询的数据:");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null) {
					System.out.println("找到数据" + aKey);
				} else {
					System.out.println("没找到数据" + aKey);
				}
				break;
			default:
				System.out.print("无效输入");
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
