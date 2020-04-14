package h_tree.B_tree234;

public class Node {
	private static final int ORDER = 4;
	private int numItems;// 当前数据项个数
	private Node parent;// 父节点
	private Node childArray[] = new Node[ORDER];// 子节点
	private DataItem itemArray[] = new DataItem[ORDER - 1];// 节点数据

	/**
	 * 根据索引连接子节点
	 * 
	 * @存储的子节点2种情况 1：为null，不进行任何操作 2：不为null，子节点添加父节点
	 * @param childNum
	 *            连接子节点的索引
	 * @param child
	 *            子节点
	 */
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * 根据索引断开子节点的连接
	 * 
	 * @param childNum
	 *            子节点的索引
	 * 
	 * @return 返回断开的子节点
	 */
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	/**
	 * 根据索引获得子节点
	 * 
	 * @param childNum
	 * @return
	 */
	public Node getChild(int childNum) {
		return childArray[childNum];
	}

	/**
	 * 获取父节点
	 * 
	 * @return
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * 判断是否为叶节点
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return childArray[0] == null;
	}

	/**
	 * 获取节点的数据项个数
	 * 
	 * @return
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * 根据索引获取对应数据条目
	 * 
	 * @param index
	 * @return
	 */
	public DataItem getDataItem(int index) {
		return itemArray[index];
	}

	/**
	 * 判断数据项是否满
	 * 
	 * @return
	 */
	public boolean isFull() {
		return numItems == ORDER - 1;
	}

	/**
	 * 查询数据项值，并返回索引
	 * 
	 * @param key
	 * @return
	 */
	public int findItem(long key) {
		for (int i = 0; i < numItems; i++) {
			if (itemArray[i] == null)
				break;
			else if (itemArray[i].dData == key) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 插入数据项，并返回索引
	 * 
	 * @param newItem
	 * @return
	 */
	public int insertItem(DataItem newItem) {
		numItems++;
		long newKey = newItem.dData;
		for (int i = ORDER - 2; i >= 0; i--) {
			if (itemArray[i] == null)
				continue;
			else {
				long itsKey = itemArray[i].dData;
				if (itsKey > newKey) {
					itemArray[i + 1] = itemArray[i];
				} else {
					itemArray[i + 1] = newItem;
					return i + 1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}

	/**
	 * 删除数据项并返回数据项,从后往前删
	 */
	public DataItem removeItem() {
		--numItems;
		DataItem temp = itemArray[numItems];
		itemArray[numItems] = null;
		return temp;

	}

	/**
	 * 显示
	 */
	public void displayNode() {
		for (int i = 0; i < numItems; i++) {
			itemArray[i].displayItem();
			System.out.print("/");
		}
		System.out.println();
	}

}
