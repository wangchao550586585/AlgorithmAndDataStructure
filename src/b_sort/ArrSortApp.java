package b_sort;

/**
 * ����
 * 
 * @author Administrator
 *
 */
public class ArrSortApp {
	public static void main(String[] args) {
		int maxSize = 10;
		ArrSort theArrbubble = new ArrSort(maxSize);

		// for (int i = 0; i < maxSize; i++) {
		// int sum = (int) (Math.random() * (maxSize) * 7);
		// theArrbubble.insert(sum);
		// }

		theArrbubble.insert(10);
		theArrbubble.insert(0);
		theArrbubble.insert(0);
		theArrbubble.insert(75);
		theArrbubble.insert(57);
		theArrbubble.insert(57);
		theArrbubble.insert(0);
		theArrbubble.insert(0);
		theArrbubble.insert(0);
		theArrbubble.insert(1);

		// theArrbubble.display();

		// ð������
		// theArrbubble.buSort();

		// ��β������
		// theArrbubble.buSort1();

		// ��ż����
		// theArrbubble.oddEvenSort();

		// ѡ������
		// theArrbubble.selectSort();

		// ��������
		theArrbubble.display();
		// theArrbubble.insertSort();

		// ��ȡ�м�ֵ
		// theArrbubble.median();

		// ȥ���ظ�ֵ
		// theArrbubble.noDups();

		theArrbubble.display();

	}
}
