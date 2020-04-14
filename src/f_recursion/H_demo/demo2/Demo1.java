package f_recursion.H_demo.demo2;

/**
 * 背包问题
 * 
 * @author Administrator
 * 
 */
public class Demo1 {
	static int arr[] = { 11, 8, 7, 6, 5 };
	static int length = arr.length;
	static Stack s;

	public static void main(String[] args) {
		s = new Stack(length);
		operation(20, 0);
	}

	public static void operation(int count, int index) {
		System.out.println(count + " " + index);
		if (count == 0) {
			s.display();
			return;
		}
		// 循环每一个次数
		for (int i = index; i < length; i++) {
			// 操作
			Arr a = oprate(count, i);
			operation(a.getNum(), a.getIndex() + 1);
		}
	}

	private static Arr oprate(int count, int i) {
		count -= arr[i];
		s.push(new Arr(arr[i], i));

		if (count > 0) {
			if (i == length - 1) {
				Arr a1 = s.pop();
				Arr a2 = s.pop();
				int i1 = a1.getIndex();
				int i2 = a2.getIndex();
				count = a1.getNum() + a2.getNum();
				if (i1 - 1 != i2) {
					i = i2;
				} else {
					s = new Stack(length);
				}

			}
		} else if (count < 0) {
			if (i < length - 1) {
				count += s.pop().getNum();
			}
			if (i == length - 1) {
				Arr a1 = s.pop();
				Arr a2 = s.pop();

				int i1 = a1.getIndex();
				int i2 = a2.getIndex();
				count = a1.getNum() + a2.getNum();
				if (i1 - 1 != i2&&!s.isEmpty()) {
					i = i2;
				} else {
					s = new Stack(length);
				}

			}
		}
		Arr a = new Arr(count, i);
		return a;
	}
}
