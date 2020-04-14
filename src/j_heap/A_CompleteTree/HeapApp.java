package j_heap.A_CompleteTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 基于完全二叉树实现,并且由数组存储的堆
 * @author Administrator
 *
 */
public class HeapApp {
	public static void main(String[] args) throws IOException {
		int value, value2;
		Heap theHeap = new Heap(31);
		boolean success;
		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(30);
		theHeap.insert(50);
		theHeap.insert(80);
		theHeap.insert(100);
		theHeap.insert(20);
		theHeap.insert(58);
		theHeap.insert(60);

		while (true) {
			System.out.println("请输入操作的首字母");
			System.out.println("show insert remove or change: ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHeap.displayHeap();
				break;
			case 'i':
				System.out.print("请输入要插入的值：");
				value = getInt();
				success = theHeap.insert(value);
				if (!success)
					System.out.println("无法插入，堆已满");
				break;
			case 'r':
				if (!theHeap.isEmpty()) {
					theHeap.remove();
				} else {
					System.out.println("移除失败");
				}
				break;
			case 'c':
				System.out.println("分别写出修改的下标和值:");
				value = getInt();
				value2 = getInt();
				success = theHeap.change(value, value2);
				if (!success) {
					System.out.println("无效索引");
				}
				break;
			default:
				System.out.println("无效操作");
			}
		}

	}

	private static char getChar() throws IOException {
		return getString().charAt(0);
	}

	private static String getString() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	private static int getInt() throws NumberFormatException, IOException {
		return Integer.parseInt(getString());
	}
}
