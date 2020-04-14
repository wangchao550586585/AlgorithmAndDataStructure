package d_queue.A_queue;

public class Queue {
	private int arr[];
	private int maxSize;// �����С
	private int front;// ǰ������
	private int rear;// ��������
	private int nItems;// �������

	public Queue(int size) {
		maxSize = size;
		arr = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(int key) {
		// ��ֹ������
		if (rear == maxSize - 1)
			rear = -1;// ����
		arr[++rear] = key;
		nItems++;
	}

	public int remove() {
		int temp = arr[front++];
		// ��Ϊ���벻���磬����ɾ��Ҳ�����磬�ж�ɾ����������Ƿ񳬹�������������
		if (front == maxSize)
			front = 0;// ����
		nItems--;
		return temp;

	}

	public int peekFront() {

		return arr[front];
	}

	public boolean isEmpty() {

		return nItems == 0;
	}

	public boolean isFull() {

		return nItems == maxSize;
	}

	public int size() {
		return nItems;
	}

	/**
	 * ��ʾ����
	 */
	public void display() {
		// 3�������
		// 1��f<r��ֱ��ѭ��k-rѭ������
		// 2��f>r��ѭ��f<maxSize����ѭ��0<=r
		// 3:f=r������Ϊ1��ֱ����ʾ������Ϊ1˵����ѭ��f<maxSize,0<r
		if (front < rear) {
			for (int i = front; i <= rear; i++) {
				System.out.print(arr[i] + " ");
			}
		} else if (front > rear) {
			for (int i = front; i < maxSize; i++) {
				System.out.print(arr[i] + " ");
			}
			for (int k = 0; k <= rear; k++) {
				System.out.print(arr[k] + " ");
			}
		} else {
			int s = size();
			if (1 == s) {
				System.out.println(arr[front]);
			} else {
				System.out.println("1");
				for (int i = front; i < maxSize; i++) {
					System.out.print(arr[i] + " ");
				}
				for (int k = 0; k < rear; k++) {
					System.out.print(arr[k] + " ");
				}
			}
		}
	}

}
