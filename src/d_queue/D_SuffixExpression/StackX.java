package d_queue.D_SuffixExpression;

public class StackX {
	private int maxSize;
	private char[] stackArray;
	private int top;

	public StackX(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char c) {
		stackArray[++top] = c;
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	public char peekN(int n) {
		return stackArray[n];
	}

	/*
	 * ÏÔÊ¾¶ÑÕ»
	 */
	public void displaysStack(String s) {
		System.out.print(s);
		System.out.print(" Stack {bottom-->top}:");
		for (int j = 0; j < size(); j++) {
			System.out.print(peekN(j));
			System.out.print(" ");
		}
		System.out.println();
	}
}
