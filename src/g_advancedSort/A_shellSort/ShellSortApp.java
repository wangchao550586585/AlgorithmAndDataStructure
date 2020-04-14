 package g_advancedSort.A_shellSort;

/**
 * 希尔排序:基于插入排序，加大插入排序中元素之间间隔，在有间隔元素中进行插入排序。
 * 
 * @author Administrator
 *
 */
public class ShellSortApp {
	public static void main(String[] args) {
		int maxSize = 10;
		ArraySh arraySh = new ArraySh(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (int) (Math.random() * 99);
			arraySh.insert(n);
		}
		arraySh.displays();
		arraySh.shellSort();
		arraySh.displays();

	}
}
