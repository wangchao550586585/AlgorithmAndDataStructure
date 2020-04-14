package g_advancedSort.C_quickSort;

public class ArrayIns {
	private long[] theArray;
	private int nElems;

	public ArrayIns(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public void display() {
		System.out.println("A = ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
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
		if (right - left <= 0) {
			return;
		} else {
			long pivot = theArray[right];

			int partition = parttitionIt(left, right, pivot);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);	
		}
	}

	/*
	 * 划分
	 */
	private int parttitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			while (theArray[++leftPtr] < pivot)//leftPtr-1划分数组之外
				;
			while (rightPtr > 0 && theArray[--rightPtr] > pivot)//right划分子数组之外
				;
			if (leftPtr >= rightPtr)//2种情况，最大和最小值时停止
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}

	/*
	 * 交换
	 */
	public void swap(int dex1, int dex2) {
		long temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
