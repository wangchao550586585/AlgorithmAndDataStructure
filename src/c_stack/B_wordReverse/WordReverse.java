package c_stack.B_wordReverse;

public class WordReverse {
	private int maxSize;
	private char[] stackArray;
	private int top;

	public WordReverse(int max) {
		maxSize = max;
		stackArray = new char[max];
		top = -1;
	}
	/*
	 * ��ջ
	 */
	public void push(char i){
		stackArray[++top]=i;
	}
	/*
	 * ��ջ
	 */
	public char pop(){
		return stackArray[top--];
	}
	/*
	 * �鿴
	 */
	public char peek(){
		return stackArray[top];
	}
	/*
	 * ջ�Ƿ�Ϊ��
	 */
	public boolean isEmpty(){
		return top==-1;
	}
	/*
	 * ջ�Ƿ���
	 */
	public boolean isFull(){
		return top==maxSize-1;
	}
}
