package j_heap.B_heapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ������ 
 * ������ʾ��ʱ���С����Ϊ�����������Ϊ����������������0�����޷���ʾ������С�򲻻�
 * ȱ�㣺û�����ε�Heap��ԶѵĲ���(insertAt()����)������Ͷѽṹ��ϵ����
 * @author Administrator
 *
 */
public class HeapApp {
	public static void main(String[] args) throws Exception {
		int size, j;
		System.out.print("�����������С:");
		size = getInt();
		Heap theHeap = new Heap(size);

		// �����������
		for (j = 0; j < size; j++) {
			int random = (int) (Math.random() * 100);
			Node newNode = new Node(random);
			theHeap.insert(j, newNode);
			theHeap.incrementSize();
		}

		// ��ʾ�������
		System.out.print("Random: ");
		theHeap.displayArray();

		// ���ӽڵ�Ľڵ���ڶ�Ӧ��λ����
		for (j = size / 2 - 1; j >= 0; j--) {
			theHeap.trickleDown(j);
		}

		// ����+����ʾ
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
