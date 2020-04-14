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
		if (currentSize == maxSize)// 判断是否超过数组容量
			return false;

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	/**
	 * 向上筛选
	 * 
	 * @param index
	 */
	private void trickleUp(int index) {
		int parent = (index - 1) / 2;// 父节点索引
		Node bottom = heapArray[index];// 临时存储index节点
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
	 * 向下筛选
	 * 
	 * @param index
	 */
	private void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index];
		while (index < currentSize / 2) {// 倒数第二层叶子节点
			// 获取左右子节点
			int childLeft = index * 2 + 1;
			int childRight = childLeft + 1;

			// 获取最大子节点， childRight<currentSize防止过界
			if (childRight < currentSize
					&& heapArray[childRight].getiData() > heapArray[childLeft]
							.getiData()) {
				largerChild = childRight;
			} else {
				largerChild = childLeft;
			}
			// 判断是否大于子节点
			if (top.getiData() >= heapArray[largerChild].getiData()) {
				break;
			}

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}

	/**
	 * 修改
	 * 
	 * @param index
	 *            索引
	 * @param newValue
	 *            值
	 * @return
	 */
	public boolean change(int index, int newValue) {
		// 索引超出范围返回false
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
			// 最外层空白显示
			if (column == 0) {
				for (int k = 0; k < nBlanks; k++) {
					System.out.print(' ');
				}
			}
			System.out.print(heapArray[j].getiData());
			// 超过数组个数，退出
			if (++j == currentSize)
				break;
			// 中间层显示结束后，跳到第二阶，控制最外层空白显示，列数清零,每行项乘2
			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else {
				// 中间层加显示
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			}
		}
		System.out.println("\n" + dots + dots);
	}
}
