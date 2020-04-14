package a_array.B_TwoPointsSearch_Object;

/**
 * ����洢���󣬲�������ɾ��
 * 
 * @author Administrator
 *
 */
public class ClassDataArray {
	private Person[] arr;
	private int arrElems;// ����Ԫ��

	public ClassDataArray(int max) {
		arr = new Person[max];
		this.arrElems = 0;
	}

	/*
	 * �����ղ�ѯ
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
	 * ɾ��
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
	 * ��ʾ
	 */
	public void displays() {
		for (int i = 0; i < arrElems; i++) {
			arr[i].displaysPersion();
		}
	}

}
