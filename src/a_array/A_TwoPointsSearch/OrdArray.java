package a_array.A_TwoPointsSearch;

/**
 * ���ֲ��ң���ɾ�� �ŵ㣺��ѯ�ٶȱ���������� ȱ�㣺ɾ��������Ϊ�����������ǰ�ƶ������ɾ��������Ķ� ����������Ҫ�ƶ������������������������������ֵ
 * 
 * @author Administrator
 *
 */
/**
 * @author Administrator
 * 
 */
public class OrdArray {
	private int aElemes;// �������Ŀ
	private long[] a;

	public OrdArray(int max) {
		a = new long[max];
		aElemes = 0;
	}

	/**
	 * ���ش�С
	 */
	public int size() {
		return aElemes;
	}

	/**
	 * ����ֵ��ѯ�Ƿ����������
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
	 * ��������
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
	 * ɾ������
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
	 * displays array contents ��ʾ����������
	 */
	public void display() {
		for (int i = 0; i < aElemes; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * �������ؼ���
	 * 
	 * @return
	 */
	public long getMex() {
		return aElemes > 0 ? a[aElemes - 1] : -1;
	}

	/**
	 * ɾ�����ؼ���
	 * 
	 * @return
	 */
	public long removeMax() {
		return aElemes > 0 ? a[--aElemes] : -1;

	}

	/**
	 * ��������ʽ
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
