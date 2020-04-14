package b_sort;

/**
 * ≈≈–Ú
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

		// √∞≈›≈≈–Ú
		// theArrbubble.buSort();

		// º¶Œ≤æ∆≈≈–Ú
		// theArrbubble.buSort1();

		// ∆Ê≈º≈≈–Ú
		// theArrbubble.oddEvenSort();

		// —°‘Ò≈≈–Ú
		// theArrbubble.selectSort();

		// ≤Â»Î≈≈–Ú
		theArrbubble.display();
		// theArrbubble.insertSort();

		// ªÒ»°÷–º‰÷µ
		// theArrbubble.median();

		// »•≥˝÷ÿ∏¥÷µ
		// theArrbubble.noDups();

		theArrbubble.display();

	}
}
