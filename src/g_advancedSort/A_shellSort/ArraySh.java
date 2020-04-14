package g_advancedSort.A_shellSort;

public class ArraySh {
	private long[] theArray;
	private int nElems;

	public ArraySh(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public void displays() {
		System.out.print("A = ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 希尔排序
	 */
	public void shellSort() {
		int inner, outer;
		long temp;
		int h = 1;// 初始值
		/*
		 * 1:获取数据项之间的间隔
		 */
		while (h <= nElems / 3) {
			h = h * 3 + 1;
		}
		/*
		 * 2：通过插入排序+减少插入排序间隔排序
		 */
		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;
				while (inner > h - 1 && theArray[inner - h] >= temp) {
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}

}
