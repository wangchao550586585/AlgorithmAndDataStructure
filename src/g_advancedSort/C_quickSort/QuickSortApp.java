package g_advancedSort.C_quickSort;
/**
 * 快速排序,最右边的值为枢纽
 * @author Administrator
 *
 */
public class QuickSortApp {
	public static void main(String[] args) {
		int maxSize = 10;
		ArrayIns arr = new ArrayIns(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (int) (Math.random() * 99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
	}
}
