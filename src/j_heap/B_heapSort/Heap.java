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
	 * 向下筛选 把index索引对应的数组值放在对应的位置上
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
	 * 二叉树显示
	 */
	public void displayHeap() {
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = -1;
		while (j++ < currentSize - 1) {// 1:currentSize>0
			// 外层空白
			if (column == 0) {
				for (int i = 0; i < nBlanks; i++) {
					System.out.print(' ');
				}
			}
			System.out.print(heapArray[j].getiData());
			// 2:if(++j==currentSize)break;

			// 控制换行和中间空白
			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				// 换第二层
				System.out.println();
			} else {// 中间空白
				for (int i = 0; i < nBlanks * 2 - 2; i++) {
					System.out.print(' ');
				}
			}
		}
		System.out.println();
	}

	/**
	 * 数组显示
	 */
	public void displayArray() {
		//大小不能为数组个数，因为堆排序后，数组个数清0，将无法显示。而大小则不会
		for (int i = 0; i < maxSize; i++) {
			System.out.print(heapArray[i].getiData() + " ");
		}
		System.out.println();
	}

	/**
	 * 对应索引插入节点
	 * 
	 * @param index
	 * @param newNode
	 */
	public void insert(int index, Node newNode) {
		heapArray[index] = newNode;

	}

	/**
	 * 增长个数
	 */
	public void incrementSize() {
		currentSize++;
	}
}
