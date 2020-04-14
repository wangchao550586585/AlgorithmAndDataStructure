package f_recursion.C_binarySearch;


public class BinarySearchApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ordArray arr = new ordArray(maxSize);

		arr.insert(72);
		arr.insert(62);
		arr.insert(90);
		arr.insert(45);
		arr.insert(65);
		arr.insert(76);
		arr.insert(78);
		arr.insert(23);
		arr.insert(45);
		arr.insert(56);
		arr.insert(67);
		arr.insert(456345);
		arr.insert(54645);
		arr.insert(146);
		arr.insert(54465);

		arr.display();

		int searchKey = 45;
		if (arr.find(searchKey) != arr.size())
			System.out.println(searchKey);
		else {
			System.out.println("ahello");
		}
	}
}
