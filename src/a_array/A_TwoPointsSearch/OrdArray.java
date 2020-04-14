package a_array.A_TwoPointsSearch;

/**
 * 二分查找，增删。 优点：查询速度比无序数组快 缺点：删除慢，因为数据项必须向前移动来填补已删除数据项的洞 增加慢，需要移动大于增加数所对用索引后面的所有值
 * 
 * @author Administrator
 *
 */
/**
 * @author Administrator
 * 
 */
public class OrdArray {
	private int aElemes;// 数组的数目
	private long[] a;

	public OrdArray(int max) {
		a = new long[max];
		aElemes = 0;
	}

	/**
	 * 返回大小
	 */
	public int size() {
		return aElemes;
	}

	/**
	 * 根据值查询是否存在于数组
	 * 
	 * @param searchKey
	 * @return
	 */
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = aElemes - 1;
		int index;
		while (true) {
			index = (lowerBound + upperBound) / 2;
			if (a[index] == searchKey) {
				return index;
			} else if (lowerBound > upperBound) {
				return aElemes;
			} else {
				if (a[index] > searchKey) {
					upperBound = index - 1;
				} else {
					lowerBound = index + 1;
				}
			}// end else divide range
		}// end while
	}// end find

	/**
	 * 插入数据
	 * 
	 * @param i
	 */
	public void insert(int i) {
		int index;
		for (index = 0; index < aElemes; index++) {
			if (a[index] > i) {
				break;
			}
		}

		for (int k = aElemes; k > index; k--) {
			a[k] = a[k - 1];
		}
		a[index] = i;
		aElemes++;
	}

	/**
	 * 删除数据
	 */
	public boolean delete(long value) {
		int index = find(value);
		if (index == aElemes) {
			return false;
		} else {
			for (int k = index; k < aElemes; k++) {
				a[k] = a[k + 1];
			}
			aElemes--;
			return true;
		}

	}

	/**
	 * displays array contents 显示数数组内容
	 */
	public void display() {
		for (int i = 0; i < aElemes; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 返回最大关键字
	 * 
	 * @return
	 */
	public long getMex() {
		return aElemes > 0 ? a[aElemes - 1] : -1;
	}

	/**
	 * 删除最大关键字
	 * 
	 * @return
	 */
	public long removeMax() {
		return aElemes > 0 ? a[--aElemes] : -1;

	}

	/**
	 * 更改排序方式
	 */
	public void reverseOrder() {
		long temp;
		for (int i = 0; i < aElemes / 2; i++) {
			temp = a[i];
			a[i] = a[aElemes - 1 - i];
			a[aElemes - 1 - i] = temp;
		}
	}
}
