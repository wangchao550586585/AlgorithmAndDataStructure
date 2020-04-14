package e_link.F_sortedList;
/**
 * ”––Ú¡¥±Ì
 * @author Administrator
 *
 */
public class SortedListApp {
	public static void main(String[] args) {
		SortedList theSort = new SortedList();
		theSort.insert(10);
		theSort.insert(80);
		theSort.displayList();
		theSort.insert(5);
		theSort.insert(30);
		System.out.println("-----");
		theSort.displayList();

		theSort.remove();
		theSort.remove();
		theSort.remove();
		System.out.println("-----");
		theSort.displayList();
	}
}
