package g_advancedSort.B_partition;

public class ArrayPar {
	private long[] arr;
	private int nElems;

	public ArrayPar(int max) {
		arr = new long[max];
		nElems = 0;
	}

	public void insert(long d) {
		arr[nElems++] = d;
	}

	public int size() {
		return nElems;
	}

	public void displays() {
		System.out.print("A = ");
		for (int i = 0; i < nElems; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}


	/**
	 * @param left 上边界
	 * @param right 下边界
	 * @param pivot 枢纽值,划分值
	 * @return	返回小于枢纽值个数，也就是从多少位开始划分
	 */
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while (true) {
//			leftPtr < right:控制循环,避免数组下标越界
			while (leftPtr < right && arr[++leftPtr] < pivot)//找到更大的项目
				;
//			rightPtr > left:控制循环
			while (rightPtr > left && arr[--rightPtr] > pivot)//找到更小的项目
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);//交换
		}
		return leftPtr; //返回分区
	}

	/*
	 * 交换
	 */
	private void swap(int dex1, int dex2) {
		long temp;
		temp = arr[dex1];
		arr[dex1] = arr[dex2];
		arr[dex2] = temp;
	}
}
