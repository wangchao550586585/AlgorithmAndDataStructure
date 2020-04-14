package j_heap.A_CompleteTree;

public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;

	public Heap(int mx) {
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean insert(int key) {
		if (currentSize == maxSize)// �ж��Ƿ񳬹���������
			return false;

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	/**
	 * ����ɸѡ
	 * 
	 * @param index
	 */
	private void trickleUp(int index) {
		int parent = (index - 1) / 2;// ���ڵ�����
		Node bottom = heapArray[index];// ��ʱ�洢index�ڵ�
		while (index > 0 && heapArray[parent].getiData() < bottom.getiData()) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (index - 1) / 2;
		}
		heapArray[index] = bottom;
	}

	public Node remove() {
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}

	/**
	 * ����ɸѡ
	 * 
	 * @param index
	 */
	private void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index];
		while (index < currentSize / 2) {// �����ڶ���Ҷ�ӽڵ�
			// ��ȡ�����ӽڵ�
			int childLeft = index * 2 + 1;
			int childRight = childLeft + 1;

			// ��ȡ����ӽڵ㣬 childRight<currentSize��ֹ����
			if (childRight < currentSize
					&& heapArray[childRight].getiData() > heapArray[childLeft]
							.getiData()) {
				largerChild = childRight;
			} else {
				largerChild = childLeft;
			}
			// �ж��Ƿ�����ӽڵ�
			if (top.getiData() >= heapArray[largerChild].getiData()) {
				break;
			}

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}

	/**
	 * �޸�
	 * 
	 * @param index
	 *            ����
	 * @param newValue
	 *            ֵ
	 * @return
	 */
	public boolean change(int index, int newValue) {
		// ����������Χ����false
		if (index < 0 || index >= currentSize)
			return false;
		int oldVal = heapArray[index].getiData();
		heapArray[index].setiData(newValue);
		if (oldVal > newValue)
			trickleDown(index);
		else if (oldVal < newValue)
			trickleUp(index);
		return true;
	}

	public void displayHeap() {
		System.out.println("heapArray: ");
		for (int i = 0; i < currentSize; i++) {
			if (heapArray[i] != null) {
				System.out.print(heapArray[i].getiData() + " ");
			} else {
				System.out.print("-- ");
			}
		}
		System.out.println();

		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "..............";
		System.out.println(dots + dots);
		while (currentSize > 0) {
			// �����հ���ʾ
			if (column == 0) {
				for (int k = 0; k < nBlanks; k++) {
					System.out.print(' ');
				}
			}
			System.out.print(heapArray[j].getiData());
			// ��������������˳�
			if (++j == currentSize)
				break;
			// �м����ʾ�����������ڶ��ף����������հ���ʾ����������,ÿ�����2
			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else {
				// �м�����ʾ
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			}
		}
		System.out.println("\n" + dots + dots);
	}
}
