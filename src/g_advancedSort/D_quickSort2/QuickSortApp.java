package g_advancedSort.D_quickSort2;
/**
 * 利用三数据取中划分的快速排序算法
 * @author Administrator
 *
 */
public class QuickSortApp {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayIns arr = new ArrayIns(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (int) (Math.random() * 199);
			arr.insert(n);
		}
		arr.displays();
		arr.quickSort();
		arr.displays();
	}
}
