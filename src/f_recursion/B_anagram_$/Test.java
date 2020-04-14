package f_recursion.B_anagram_$;

public class Test {
	static char[] arr = { 'a', 'b', 'c' };
	static int length = arr.length;

	public static void main(String[] args) {
		fun(length);
	}

	private static void fun(int size) {
		for (int i = 0; i < size; i++) {
			fun(size - 1);
			if (size == 2)
				display();
			rotate(size);
		}
	}

	private static void display() {
		for (char c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	private static void rotate(int size) {
		int position = length - size;
		char temp = arr[position];
		int i = position;
		for (; i < length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}

}
