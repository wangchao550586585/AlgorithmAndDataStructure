package c_stack.C_matching;

public class StackX {
	private int maxSize; 
	private char[] stackArray;
	private int top;

	public StackX(int s) {
		maxSize = s;
		stackArray = new char[s];
		top = -1;
	}

	public void push(char j) {
		stackArray[++top] = j;
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}/*
	 * ջ�Ƿ���
	 */

	public boolean isFull() {
		return top == maxSize - 1;
	}

}
