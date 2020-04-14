package j_heap.B_heapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 堆排序 
 * 数组显示的时候大小不能为数组个数，因为堆排序后，数组个数清0，将无法显示。而大小则不会
 * 缺点：没有屏蔽掉Heap类对堆的操作(insertAt()方法)，数组和堆结构联系紧密
 * @author Administrator
 *
 */
public class HeapApp {
	public static void main(String[] args) throws Exception {
		int size, j;
		System.out.print("请输入数组大小:");
		size = getInt();
		Heap theHeap = new Heap(size);

		// 随机填入数字
		for (j = 0; j < size; j++) {
			int random = (int) (Math.random() * 100);
			Node newNode = new Node(random);
			theHeap.insert(j, newNode);
			theHeap.incrementSize();
		}

		// 显示随机数组
		System.out.print("Random: ");
		theHeap.displayArray();

		// 有子节点的节点放在对应的位置上
		for (j = size / 2 - 1; j >= 0; j--) {
			theHeap.trickleDown(j);
		}

		// 数组+树显示
		System.out.print("Heap: ");
		theHeap.displayArray();
		theHeap.displayHeap();

		for (j = size - 1; j >= 0; j--) {
			Node biggestNode = theHeap.remove();
			theHeap.insert(j, biggestNode);
		}
		System.out.print("Sorted: ");
		theHeap.displayArray();
	}

	private static String getString() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	private static int getInt() throws NumberFormatException, IOException {
		return Integer.parseInt(getString());
	}
}
