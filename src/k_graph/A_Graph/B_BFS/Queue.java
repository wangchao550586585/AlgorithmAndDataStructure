package k_graph.A_Graph.B_BFS;

/**
 * 队列
 * 
 * @author Administrator
 * 
 */
public class Queue {
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;

	public Queue() {
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}

	public void insert(int key) {
		if (rear == SIZE - 1)
			rear = -1;
		queArray[++rear] = key;
	}

	public int remove() {
		int temp = queArray[front++];
		if (front == SIZE)
			front = 0;
		return temp;
	}

	public boolean isEmpty() {
		return (rear + 1 == front) || (front + SIZE - 1 == rear);
	}
}
