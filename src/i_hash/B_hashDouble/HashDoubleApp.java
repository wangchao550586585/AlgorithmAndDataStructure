package i_hash.B_hashDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用在哈希法存储数据
 * 
 * @author Administrator
 * 
 */
public class HashDoubleApp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int size, n, aKey;
		DataItem aDataItem;
		System.out.print("请指定哈希表的大小: ");
		size = getInt();
		System.out.print("指定哈希表初始化数据量：");
		n = getInt();
		HashTable theHashTable = new HashTable(size);
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * 2 * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aKey, aDataItem);
		}
		while (true) {
			System.out.print("请输入第一个字母：");
			System.out.println("find,insert,show or delete");
			char choice = getChar();
			switch (choice) {
			case 'i':
				System.out.print("请输入要插入的值: ");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aKey, aDataItem);
				break;
			case 's':
				theHashTable.display();
				break;
			case 'f':
				System.out.print("请输入要查询的值: ");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null) {
					System.out.println("找到值：" + aKey);
				} else {
					System.out.println("没有找到值：" + aKey);
				}
				break;
			case 'd':
				System.out.println("请输入要删除的值：");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;

			default:
				System.out.println("无效输入！！！");
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
