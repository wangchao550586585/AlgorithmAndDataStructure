package k_graph.A_Graph.A_DFS;

public class StackX {
	public final int SIZE = 20;
	public int[] st;
	public int top;

	public StackX() {
		st = new int[SIZE];
		top = -1;
	}

	public void push(int j) {
		st[++top] = j;
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
