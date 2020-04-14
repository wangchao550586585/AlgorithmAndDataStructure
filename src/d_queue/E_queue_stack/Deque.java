package d_queue.E_queue_stack;

public class Deque {
	private int[] arr;
	private int maxSize;
	private int left;
	private int right;
	private int aItems;

	public Deque(int s) {
		maxSize = s;
		arr = new int[maxSize];
		right = 0;
		left = -1;
		aItems = 0;
	}

	public void push(int key) {
		if (right == maxSize)
			right = 0;
		arr[right++] = key;
		aItems++;

	}

	public int pop() {
		int temp = -1;
		if (aItems != 0) {

			if (left == -1)
				left = maxSize - 1;
			// ���յ������
			while (arr[left--] == 0) {
				if (left == -1)
					left = maxSize - 1;
			}
			temp = arr[left+1];

		}
		aItems--;
		return temp;
	}

	public boolean isEmpty() {
		return aItems == 0;
	}

	public boolean isFull() {
		return aItems == maxSize;
	}

}
