package c_stack.A_array;

/**
 * ����ģ��ջ
 * push:top+1��Ȼ����top+1������Ӧ��λ�������ֵ
 * pop������top��Ӧ��ֵ��Ȼ��top-1
 * ��������ջûֵ������ֵ��
 * 		ջ�������ֵ
 * 
 * @author Administrator
 *
 */
public class Array_stack {
	private int maxSize;
	private long[] stackArray;
	private int top;

	/*
	 * ��ʼ�������С����ջ��ֵ
	 */
	public Array_stack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}

	/*
	 * ��ջ
	 */
	public void push(long j) {
		stackArray[++top] = j;
	}

	/*
	 * ��ջ
	 */
	public long pop() {
		return stackArray[top--];
		
	}
	/*
	 * �鿴
	 */
	public long peek(){
		return stackArray[top];
	}
	/*
	 * �鿴�Ƿ�Ϊ��
	 */
	public boolean isEmpty(){
		return (top==-1);
	}
	/*
	 * ջ�Ƿ����
	 */
	public boolean isFull(){
		return (top==maxSize-1);
	}
}

