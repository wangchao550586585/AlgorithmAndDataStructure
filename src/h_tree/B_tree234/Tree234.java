package h_tree.B_tree234;

public class Tree234 {
	private Node root = new Node();

	/**
	 * 根据值查询数据项，并返回索引
	 * 
	 * @param key
	 * @return
	 */
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1) {
				return childNumber;
			} else if (curNode.isLeaf()) {
				return -1;
			} else {
				getNextChild(curNode, key);
			}

		}
	}

	/**
	 * 插入数据项
	 * 
	 * @param dValue
	 */
	public void insert(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		while (true) {
			// 判断数据项是否满了
			if (curNode.isFull()) {
				split(curNode);// 分割
				curNode = curNode.getParent();// 获取父节点
				curNode = getNextChild(curNode, dValue);// 获取下一个节点
			} else if (curNode.isLeaf()) {
				break;
			} else {
				curNode = getNextChild(curNode, dValue);
			}
		}
		curNode.insertItem(tempItem);// 数据项插入叶节点

	}

	/**
	 * 获得子节点
	 * 
	 * @param curNode
	 * @param key
	 * @return
	 */
	public Node getNextChild(Node curNode, long key) {
		int j;
		int numItems = curNode.getNumItems();
		for (j = 0; j < numItems; j++) {
			if (key < curNode.getDataItem(j).dData) {
				return curNode.getChild(j);
			}
		}
		return curNode.getChild(j);
	}

	/**
	 * 分割数据项满的节点
	 * 
	 * @param thisNode
	 */
	public void split(Node thisNode) {
		DataItem itemC = thisNode.removeItem();
		DataItem itemB = thisNode.removeItem();

		Node child2 = thisNode.getChild(2);
		Node child3 = thisNode.getChild(3);

		Node newRight = new Node();
		Node parent;
		// 判断是否为root
		if (thisNode == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		} else {
			parent = thisNode.getParent();
		}

		int itemIndex = parent.insertItem(itemB);// 父节点存储数据项的索引
		int n = parent.getNumItems();// 获得父节点的个数
		// 由于父节点中”有序“插入新的数据项，改变了父节点的子节点的引用，所以需要修改
		for (int i = n - 1; i > itemIndex; i--) {
			Node temp = parent.getChild(i);
			parent.connectChild(i + 1, temp);
		}

		// 父节点插入子右节点
		parent.connectChild(itemIndex + 1, newRight);

		// 右节点插入数据项+连接子节点
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);

	}

	/**
	 * 遍历
	 */
	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}

	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level = " + level + " childNumber= " + childNumber
				+ " ");
		thisNode.displayNode();

		int numItems = thisNode.getNumItems();
		for (int i = 0; i < numItems + 1; i++) {
			Node nextNode = thisNode.getChild(i);
			if (nextNode != null) {
				recDisplayTree(nextNode, level + 1, i);
			} else {
				return;
			}
		}
	}
}
