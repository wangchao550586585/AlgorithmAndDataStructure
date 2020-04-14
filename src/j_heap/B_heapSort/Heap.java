package j_heap.B_heapSort;

public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;

	public Heap(int size) {
		maxSize = size;
		heapArray = new Node[maxSize];
		currentSize = 0;
	}

	public Node remove() {
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}

	/**
	 * ����ɸѡ ��index������Ӧ������ֵ���ڶ�Ӧ��λ����
	 * 
	 * @param index
	 */
	public void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index];
		while (index < currentSize / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize
					&& heapArray[rightChild].getiData() > heapArray[leftChild]
							.getiData()) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}
			if (top.getiData() >= heapArray[largerChild].getiData())
				break;
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}

	/**
	 * ��������ʾ
	 */
	public void displayHeap() {
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = -1;
		while (j++ < currentSize - 1) {// 1:currentSize>0
			// ���հ�
			if (column == 0) {
				for (int i = 0; i < nBlanks; i++) {
					System.out.print(' ');
				}
			}
			System.out.print(heapArray[j].getiData());
			// 2:if(++j==currentSize)break;

			// ���ƻ��к��м�հ�
			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				// ���ڶ���
				System.out.println();
			} else {// �м�հ�
				for (int i = 0; i < nBlanks * 2 - 2; i++) {
					System.out.print(' ');
				}
			}
		}
		System.out.println();
	}

	/**
	 * ������ʾ
	 */
	public void displayArray() {
		//��С����Ϊ�����������Ϊ����������������0�����޷���ʾ������С�򲻻�
		for (int i = 0; i < maxSize; i++) {
			System.out.print(heapArray[i].getiData() + " ");
		}
		System.out.println();
	}

	/**
	 * ��Ӧ��������ڵ�
	 * 
	 * @param index
	 * @param newNode
	 */
	public void insert(int index, Node newNode) {
		heapArray[index] = newNode;

	}

	/**
	 * ��������
	 */
	public void incrementSize() {
		currentSize++;
	}
}
