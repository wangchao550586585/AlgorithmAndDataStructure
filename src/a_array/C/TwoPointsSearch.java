package a_array.C;

public class TwoPointsSearch {
	private int nElems;
	private int[] arr;

	public TwoPointsSearch(int max) {
		super();
		arr = new int[max];
		nElems = 0;
	}

	/**
	 * �������
	 * 
	 * @param key
	 */
	public void insert(int key) {

		int i;
		// ������ȷ����
		for (i = 0; i < nElems; i++) {
			if (key < arr[i])// ?
				break;
		}
		// �ƶ�λ��
		for (int k = nElems; k > i; k--) {
			arr[k] = arr[k - 1];
		}
		// ��ֵ
		arr[i] = key;
		nElems++;
	}

	public boolean delete(int key) {
		// ������ȷ����
		int i = find(key);
		boolean flag = true;
		if (i != nElems) {
			for (; i < nElems; i++) {
				if (key == arr[i]) {
					arr[i] = arr[i + 1];
				}
			}
			nElems--;
		} else
			flag = true;

		return flag;
	}

	/**
	 * ���ֲ���
	 * 
	 * @param searchKey
	 */
	public int find(int searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int mid;
		int result = nElems;
		while (true) {
			mid = (lowerBound + upperBound) / 2;
			if (arr[mid] == searchKey) { // ?
				result = mid;
				break;
			}
			if (lowerBound > upperBound) {
				break;
			} else {
				if (arr[mid] > searchKey) {
					upperBound = mid - 1;// ?
				} else
					lowerBound = mid + 1;// ?
			}

		}
		return result;

	}

	public void display() {

		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int size() {
		return nElems;
	}

	/**
	 * ɾ���ظ�����
	 * �ظ��ؼ���ȫ���޸�Ϊ-1��Ȼ���ƶ������棬�ڼ�С�����С
	 * 
	 */
	public void noDup() {
		// �ظ��Ĺؼ���ȫ�����-1
		for (int i = 0; i < nElems; i++) {
			for (int j = 0; j < nElems; j++) {

				if (j == i)
					continue;
				if (arr[i] == arr[j]) {
					arr[j] = -1;

				}
			}
		}
		// ȫ��-1�ƶ�������
		for (int i = 0; i < nElems; i++) {
			if (arr[i] == -1) {
				for (int k = i; k < nElems; k++) {
					if (arr[k] != -1) {
						arr[i] = arr[k];
						arr[k] = -1;
						break;
					}
				}
			}
		}
		int count = 0;
		// ͳ��-1�ĸ���Ȼ���ȥ
		for (int i = 0; i < nElems; i++) {
			if (arr[i] == -1)
				count++;
		}
		nElems -= count;
	}

}
