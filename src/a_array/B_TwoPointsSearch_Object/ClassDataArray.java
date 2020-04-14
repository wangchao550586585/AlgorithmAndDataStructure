package a_array.B_TwoPointsSearch_Object;

/**
 * 数组存储对象，并进行增删查
 * 
 * @author Administrator
 *
 */
public class ClassDataArray {
	private Person[] arr;
	private int arrElems;// 数组元素

	public ClassDataArray(int max) {
		arr = new Person[max];
		this.arrElems = 0;
	}

	/*
	 * 按照姓查询
	 */
	public Person find(String searchName) {
		int j;
		for (j = 0; j < arrElems; j++) {
			if (arr[j].getLast().equals(searchName)) {
				break;
			}
		}
		if (j == arrElems) {
			return null;
		} else {
			return arr[j];
		}
	}

	/*
	 * 删除
	 */
	public boolean delete(String searchName) {
		int j;
		for (j = 0; j < arrElems; j++) {
			if (arr[j].getLast().equals(searchName)) {
				break;
			}
		}
		if (j == arrElems) {
			return false;
		} else {
			for (; j < arrElems; j++) {
				arr[j] = arr[j + 1];
			}
			arrElems--;
			return true;
		}
	}

	/**
	 * 显示
	 */
	public void displays() {
		for (int i = 0; i < arrElems; i++) {
			arr[i].displaysPersion();
		}
	}

}
