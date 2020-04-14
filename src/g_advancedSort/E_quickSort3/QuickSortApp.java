package g_advancedSort.E_quickSort3;

/**
 * 使用插入排序来处理小于10个数据项的子数组，使快速排序性能发挥到极致。
 *  一般用9作为切割点，但是最终还是要取决计算机，操作系统等。
 * 
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
