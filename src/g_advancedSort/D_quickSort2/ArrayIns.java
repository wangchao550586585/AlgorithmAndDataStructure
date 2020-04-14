package g_advancedSort.D_quickSort2;

public class ArrayIns {
	private long arr[];
	private int nElems;

	public ArrayIns(int max) {
		arr = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		arr[nElems++] = value;
	}

	public void displays() {
		System.out.print("A = ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

	/*
	 * 快速排序
	 */
	private void recQuickSort(int left, int right) {
		int size = right - left + 1;
		if (size <= 3)
			manualSort(left, right);
		else {
			long median = medianOf(left, right);// 3数据项取中，并返回中间数字值,中间数字值对应的索引为right-1
			int partition = partitionIt(left, right, median);// 返回中间索引
			recQuickSort(left, partition);
			recQuickSort(partition + 1, right);
		}
	}

	/*
	 * 返回中间索引
	 */
	private int partitionIt(int left, int right, long pivot) {
		int leftPtr = left;//
		int rightPtr = right - 1;// pivot
		while (true) {
			while (arr[++leftPtr] < pivot)
				;
			while (arr[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);// pivot和leftPtr交换
		return leftPtr;
	}

	/*
	 * 3数据项取中，并返回中间数字值
	 */
	private long medianOf(int left, int right) {
		int center = (left + right) / 2;
		if (arr[left] > arr[center])
			swap(left, center);
		if (arr[left] > arr[right])
			swap(left, right);
		if (arr[center] > arr[right])
			swap(center, right);

		swap(center, right - 1);
		return arr[right - 1];
	}

	/*
	 * 针对数组个数<=3特殊情况所做出的操作
	 */
	private void manualSort(int left, int right) {
		int size = right - left + 1;
		if (1 == size) {
			return;// break不了，又不想执行接下来的操作，所以return
		} else if (2 == size) {
			if (arr[left] > arr[right])
				swap(left, right);
			return;
		} else {
			if (arr[left] > arr[right - 1])
				swap(left, right - 1);
			if (arr[left] > arr[right])
				swap(left, right);
			if (arr[right - 1] > arr[right])
				swap(right - 1, right);
		}

	}

	/*
	 * 交换
	 */
	private void swap(int dex1, int dex2) {
		long temp = arr[dex1];
		arr[dex1] = arr[dex2];
		arr[dex2] = temp;

	}
}
