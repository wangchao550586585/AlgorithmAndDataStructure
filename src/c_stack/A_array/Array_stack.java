package c_stack.A_array;

/**
 * 数组模拟栈
 * push:top+1，然后在top+1索引对应的位置上添加值
 * pop：返回top对应的值，然后top-1
 * 常见错误，栈没值，返回值，
 * 		栈满，添加值
 * 
 * @author Administrator
 *
 */
public class Array_stack {
	private int maxSize;
	private long[] stackArray;
	private int top;

	/*
	 * 初始化数组大小，和栈顶值
	 */
	public Array_stack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}

	/*
	 * 入栈
	 */
	public void push(long j) {
		stackArray[++top] = j;
	}

	/*
	 * 出栈
	 */
	public long pop() {
		return stackArray[top--];
		
	}
	/*
	 * 查看
	 */
	public long peek(){
		return stackArray[top];
	}
	/*
	 * 查看是否为空
	 */
	public boolean isEmpty(){
		return (top==-1);
	}
	/*
	 * 栈是否充满
	 */
	public boolean isFull(){
		return (top==maxSize-1);
	}
}

