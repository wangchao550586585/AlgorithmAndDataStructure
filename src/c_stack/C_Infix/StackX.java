package c_stack.C_Infix;

public class StackX {
	private char arr[];
	private int top;
	private int maxSize;

	public StackX(int s) {
		maxSize = s;
		arr = new char[maxSize];
		top = -1;
	}

	public void push(char key) {
		arr[++top] = key;

	}

	public char pop() {
		return arr[top--];
	}

	public char peek() {
		return arr[top];
	}

	public char peekN(int n) {
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
