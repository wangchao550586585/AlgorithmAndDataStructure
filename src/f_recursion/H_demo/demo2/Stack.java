package f_recursion.H_demo.demo2;

public class Stack {
	@SuppressWarnings("unused")
	private int max;
	private int top;
	private Arr[] arr;

	public Stack(int max) {
		this.max = max;
		arr = new Arr[max];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(Arr in) {
		arr[++top] = in;
	}

	public Arr pop() {
		return arr[top--];
	}

	public Arr peek() {
		return arr[top];
	}

	public Arr top() {
		top = -1;
		return arr[0];
	}

	public void display() {
		while (!isEmpty()) {
			System.out.print(pop() + " ");
		}
	}

	// 获取栈内数据和
	public int getNum() {
		int num = 0;
		for (int i = 0; i <= top; i++)
			num += arr[i].getNum();
		return num;
	}

}
