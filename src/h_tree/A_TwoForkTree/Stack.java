package h_tree.A_TwoForkTree;

public class Stack {
	private int maxSize;
	private Object[] stackArray;
	private int top;

	public Stack() {
		maxSize = 1000;
		stackArray = new Object[1000];
		top = -1;
	}

	public void push(Object j) {
		stackArray[++top] = j;
	}

	public Object pop() {
		return stackArray[top--];
	}

	public Object peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}/*
	 * Õ»ÊÇ·ñÂú
	 */

	public boolean isFull() {
		return top == maxSize - 1;
	}

}
