package k_graph.A_Graph.C_MST;

public class StackX {
	private final int SIZE = 20;
	private int[] st;
	private int top;

	public StackX() {
		st = new int[SIZE];
		top = -1;
	}

	public void push(int key) {

		st[++top] = key;
	}

	public int peek() {

		return st[top];
	}

	public int pop() {

		return st[top--];

	}

	public boolean isEmpty() {

		return top == -1;
	}
}
