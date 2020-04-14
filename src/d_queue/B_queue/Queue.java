package d_queue.B_queue;

public class Queue {
	private int queArr[];
	private int maxSize;
	private int front;
	private int rear;

	public Queue(int maxSize) {
		this.maxSize = maxSize + 1;// ���������ȶ��и������ֵ��һ
		queArr = new int[maxSize];
		front = 0;
		rear = -1;
	}

	public void insert(int key) {

		if (rear == maxSize - 1)
			rear = -1;
		queArr[++rear] = key;

	}

	public int remove() {

		int temp = queArr[front++];
		if (front == maxSize)
			front = 0;
		return temp;
	}

	public int peek() {
		return queArr[front];
	}

	public boolean isFull() {
		return (rear + 2 == front) || (front + maxSize - 2 == rear);
	}

	public int size() {
		int size = -1;
		if (rear >= front) {
			size = rear - front + 1;
		} else {
			size = (maxSize - front) + rear + 1;
		}
		return size;
	}

	public boolean isEmpty() {
		return rear + 1 == front || front + maxSize - 1 == rear;
	}

}
