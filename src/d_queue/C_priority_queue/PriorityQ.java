package d_queue.C_priority_queue;

public class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;

	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[s];
		nItems = 0;
	}

	public void insert(long item) {
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
		int i;
		for (i = 0; i < nItems; i++) {
			if (queArray[i] < item)
				break;
		}
		for (int k = nItems - 1; k >= i; k--)
			queArray[k + 1] = queArray[k];
		queArray[i] = item;

		nItems++;
	}

	public long remove() {
		return queArray[--nItems];
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
