package h_tree.B_tree234;

public class Tree234 {
	private Node root = new Node();

	/**
	 * ����ֵ��ѯ���������������
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
	 * ����������
	 * 
	 * @param dValue
	 */
	public void insert(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		while (true) {
			// �ж��������Ƿ�����
			if (curNode.isFull()) {
				split(curNode);// �ָ�
				curNode = curNode.getParent();// ��ȡ���ڵ�
				curNode = getNextChild(curNode, dValue);// ��ȡ��һ���ڵ�
			} else if (curNode.isLeaf()) {
				break;
			} else {
				curNode = getNextChild(curNode, dValue);
			}
		}
		curNode.insertItem(tempItem);// ���������Ҷ�ڵ�

	}

	/**
	 * ����ӽڵ�
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
	 * �ָ����������Ľڵ�
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
		// �ж��Ƿ�Ϊroot
		if (thisNode == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		} else {
			parent = thisNode.getParent();
		}

		int itemIndex = parent.insertItem(itemB);// ���ڵ�洢�����������
		int n = parent.getNumItems();// ��ø��ڵ�ĸ���
		// ���ڸ��ڵ��С����򡰲����µ�������ı��˸��ڵ���ӽڵ�����ã�������Ҫ�޸�
		for (int i = n - 1; i > itemIndex; i--) {
			Node temp = parent.getChild(i);
			parent.connectChild(i + 1, temp);
		}

		// ���ڵ�������ҽڵ�
		parent.connectChild(itemIndex + 1, newRight);

		// �ҽڵ����������+�����ӽڵ�
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);

	}

	/**
	 * ����
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
