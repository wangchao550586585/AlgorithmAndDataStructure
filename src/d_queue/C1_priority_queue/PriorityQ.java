package d_queue.C1_priority_queue;

public class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;

	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[s];
		nItems = 0;
	}

	// public void insert(long item) {
	// int i;
	// if (nItems == 0)
	// queArray[0] = item;
	// else {
	// for (i = nItems - 1; i >= 0; i--) {
	// if (queArray[i] < item) {
	// queArray[i + 1] = queArray[i];
	// } else {
	// break;
	// }
	// }
	// queArray[i + 1] = item;
	// }
	//
	// nItems++;
	// }
	// public long remove() {
	// // ������С
	//
	// return queArray[--nItems];
	// }

	/**
	 * ����ʱ�临�Ӷ�Ϊ01
	 * 
	 * @param item
	 */
	public void insert(long item) {
		queArray[nItems++] = item;
	}

	public long remove() {
		// ������С
		int min = 0;
		for (int i = 1; i < nItems; i++) {
			if (queArray[min] > queArray[i]) {
				min = i;
			}
		}
		long temp = queArray[min];
		// ��λ��
		nItems--;
		for (; min < nItems; min++) {
			queArray[min] = queArray[min + 1];
		}
		return temp;
	}

	public long peekMin() {
		return queArray[nItems - 1];
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	public boolean isFull() {
		return nItems == maxSize;
	}

}
