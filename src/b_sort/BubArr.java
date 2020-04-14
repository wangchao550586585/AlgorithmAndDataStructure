package b_sort;

/**
 * ð�������ұ�����
 * 
 * @author Administrator
 *
 */
public class BubArr {
	private long[] arr;
	private int arrElems;

	public BubArr(int max) {
		arr = new long[max];
		arrElems = 0;
	}

	public void insert(long value) {
		arr[arrElems] = value;
		arrElems++;
	}

	public void bubbleArr() {
		for (int i = arrElems - 1; i > 0; i--) { // ����������Ƚ�
			for (int k = 0; k < i; k++) {// ÿһ����Ƚϼ���
				if (arr[k] > arr[k + 1]) {
					long temp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = temp;
				}

			}
		}
	}

	public static void maoPao(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {// �����м�����Ƚ�
			for (int k = 0; k < a.length - 1 - i; k++) {// �����ڼ�����ͺ���ıȽϼ��Ρ���Ϊÿ�αȽ���һ�����С��ͼ���i��
				if (a[k] > a[k + 1]) {
					temp = a[k];
					a[k] = a[k + 1];
					a[k + 1] = temp;
				}
			}
		}

	}
}
