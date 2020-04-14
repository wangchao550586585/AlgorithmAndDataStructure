package i_hash.C_hashChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 链地址法
 * 
 * @author Administrator
 *
 */
public class HashChainApp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int aKey, size, n, keysPerCell = 100;
		Link aDataItem;
		System.out.print("指定哈希表的大小:");
		size = getInt();
		System.out.print("指定哈希表初始数目:");
		n = getInt();
		HashTable theHashTable = new HashTable(size);
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);
			aDataItem = new Link(aKey);
			theHashTable.insert(aDataItem);
		}
		while (true) {
			System.out.print("请输入第一个字母：");
			System.out.print("show,find,insert or delete ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("请输入要插入的数据：");
				aKey = getInt();
				aDataItem = new Link(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("请输入要插入的数据：");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("请输入要查询的数据");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null)
					System.out.println("找到" + aKey);
				else
					System.out.println("查找失败" + aKey);
				break;

			default:
				System.out.println("无效操作");
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
