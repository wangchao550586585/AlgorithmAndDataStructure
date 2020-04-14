package f_recursion.F_mergeSort;

public class DArray {
	private long[] theArray;
	private int nElems;

	public DArray(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println();
	}

	/*
	 * 归并排序
	 */
	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		} else {
			// 计算数组中间位置
			int mid = (lowerBound + upperBound) / 2;

			// 分别对应数组的一半
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid + 1, upperBound);

			// 归并
			merge(workSpace, lowerBound, mid + 1, upperBound);
		}
	}

	private void merge(long[] workSpace, int lowPtr, int high, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = high - 1;
		int n = upperBound - lowerBound + 1;//算出新数组长度
		//3个while把原数组的值排序后存储在新数组中
		while (lowPtr <= mid && high <= upperBound) {
			if (theArray[lowPtr] < theArray[high]) {
				workSpace[j++] = theArray[lowPtr++];
			} else {
				workSpace[j++] = theArray[high++];
			}
		}

		while (lowPtr <= mid) {
			workSpace[j++] = theArray[lowPtr++];
		}
		while (high <= upperBound) {
			workSpace[j++] = theArray[high++];
		}
		//取出新数组值并返回给原数组
		for (j = 0; j < n; j++) {
			theArray[lowerBound + j] = workSpace[j];
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
