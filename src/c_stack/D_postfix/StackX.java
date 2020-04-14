package c_stack.D_postfix;

public class StackX {
	private int arr[];
	private int top;
	private int maxSize;

	public StackX(int s) {
		maxSize = s;
		arr = new int[maxSize];
		top = -1;
	}

	public void push(int key) {
		arr[++top] = key;

	}

	public int pop() {
		return arr[top--];
	}

	public int peek() {
		return arr[top];
	}

	public int peekN(int n) {
		return arr[n];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public int size() {
		return top + 1;
	}

}
