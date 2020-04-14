 package i_hash.A;

public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	} 
	/**
	 * 显示数据
	 */
	public void displayTable() {
		System.out.print("Table ");
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i] != null) {
				System.out.print(hashArray[i].getKey() + " ");
			} else {
				System.out.print("** ");
			}
			System.out.println();
		}
		
	}

	/**
	 * 取余数
	 * 
	 * @param key
	 * @return
	 */
	public int hashFunt(int key) {
		return key % arraySize;
	}

	/**
	 * 插入数据
	 * 
	 * @param item
	 */
	public void insert(DataItem item) {
		int key = item.getKey();
		int hashVal = hashFunt(key);
		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			++hashVal;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
	}

	/**
	 * 删除数据
	 * 
	 * @param key
	 * @return
	 */
	public DataItem delete(int key) {
		int hashVal = hashFunt(key);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == key) {
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;

		}
		return null;
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	public DataItem find(int key) {
		int hashVal = hashFunt(key);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == key) {

				return hashArray[hashVal];
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
}
