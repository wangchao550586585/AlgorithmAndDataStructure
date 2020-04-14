package a_array.C;

/**
 * twoPointSearch
 * 
 * @author Administrator
 *
 */
public class OrderApp {
	public static void main(String[] args) {
		TwoPointsSearch theArr = new TwoPointsSearch(20);
		theArr.insert(10);
		theArr.insert(30);
		theArr.insert(22);
		theArr.insert(75);
		theArr.insert(34);
		theArr.insert(57);
		theArr.insert(89);
		theArr.insert(49);
		theArr.insert(31);
		theArr.insert(1);

		int searchKey = theArr.find(49);
		if (searchKey == theArr.size()) {
			System.out.println("û�ҵ�");
		} else
			System.out.println("�ҵ�" + searchKey);

		theArr.display();
		theArr.delete(89);
		theArr.display();

	}
}
