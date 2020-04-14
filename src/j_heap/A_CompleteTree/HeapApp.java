package j_heap.A_CompleteTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ������ȫ������ʵ��,����������洢�Ķ�
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
			System.out.println("���������������ĸ");
			System.out.println("show insert remove or change: ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHeap.displayHeap();
				break;
			case 'i':
				System.out.print("������Ҫ�����ֵ��");
				value = getInt();
				success = theHeap.insert(value);
				if (!success)
					System.out.println("�޷����룬������");
				break;
			case 'r':
				if (!theHeap.isEmpty()) {
					theHeap.remove();
				} else {
					System.out.println("�Ƴ�ʧ��");
				}
				break;
			case 'c':
				System.out.println("�ֱ�д���޸ĵ��±��ֵ:");
				value = getInt();
				value2 = getInt();
				success = theHeap.change(value, value2);
				if (!success) {
					System.out.println("��Ч����");
				}
				break;
			default:
				System.out.println("��Ч����");
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
