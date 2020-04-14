package h_tree.B_tree234;

public class Node {
	private static final int ORDER = 4;
	private int numItems;// ��ǰ���������
	private Node parent;// ���ڵ�
	private Node childArray[] = new Node[ORDER];// �ӽڵ�
	private DataItem itemArray[] = new DataItem[ORDER - 1];// �ڵ�����

	/**
	 * �������������ӽڵ�
	 * 
	 * @�洢���ӽڵ�2����� 1��Ϊnull���������κβ��� 2����Ϊnull���ӽڵ���Ӹ��ڵ�
	 * @param childNum
	 *            �����ӽڵ������
	 * @param child
	 *            �ӽڵ�
	 */
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * ���������Ͽ��ӽڵ������
	 * 
	 * @param childNum
	 *            �ӽڵ������
	 * 
	 * @return ���ضϿ����ӽڵ�
	 */
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	/**
	 * ������������ӽڵ�
	 * 
	 * @param childNum
	 * @return
	 */
	public Node getChild(int childNum) {
		return childArray[childNum];
	}

	/**
	 * ��ȡ���ڵ�
	 * 
	 * @return
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * �ж��Ƿ�ΪҶ�ڵ�
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return childArray[0] == null;
	}

	/**
	 * ��ȡ�ڵ�����������
	 * 
	 * @return
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * ����������ȡ��Ӧ������Ŀ
	 * 
	 * @param index
	 * @return
	 */
	public DataItem getDataItem(int index) {
		return itemArray[index];
	}

	/**
	 * �ж��������Ƿ���
	 * 
	 * @return
	 */
	public boolean isFull() {
		return numItems == ORDER - 1;
	}

	/**
	 * ��ѯ������ֵ������������
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
	 * �������������������
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
	 * ɾ�����������������,�Ӻ���ǰɾ
	 */
	public DataItem removeItem() {
		--numItems;
		DataItem temp = itemArray[numItems];
		itemArray[numItems] = null;
		return temp;

	}

	/**
	 * ��ʾ
	 */
	public void displayNode() {
		for (int i = 0; i < numItems; i++) {
			itemArray[i].displayItem();
			System.out.print("/");
		}
		System.out.println();
	}

}
