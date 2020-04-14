package b_sort;

public class ArrSort {
	private int[] arr;
	private int aElems;

	public ArrSort(int max) {
		arr = new int[max];
		aElems = 0;
	}

	/**
	 * �������
	 * 
	 * @param key
	 */
	public void insert(int key) {

		arr[aElems++] = key;
	}

	/**
	 * ð������
	 */
	public void buSort() {

		for (int i = 0; i < aElems - 1; i++) {// �������Ƚ�
			for (int k = 0; k < aElems - 1 - i; k++) {// ÿ�αȽϺ����Ĺ̶���,��ȥ�̶���i
				// for (int i = aElems - 1; i > 0; i--) {// �������Ƚ�
				// for (int k = 0; k < i; k++) {// ÿ�αȽϺ����Ĺ̶���,��ȥ�̶���i
				if (arr[k] > arr[k + 1]) {
					// ����
					swap(k, k + 1);
				}

			}

		}
	}

	/**
	 * ˫��ð��(��β������)
	 */
	public void buSort1() {
		// int index = aElems - 1;
		// // ���ѭ��ÿ��ѭ�������ȷ��������ֵ��һ�����ֵһ����Сֵ������ѭ���������룬
		// // ������鳤��Ϊ����ʱ�����һ��ѭ����ʣ��һ����ֵ����ֵ��Ϊ�м�ֵ����������
		// // �У�������鳤��Ϊż��ʱ��ѭ�� aElems / 2
		// for (int in = 0; in < aElems / 2; in++) {
		// // first-last
		// // index - in���ڼ���������û����
		// for (int k = in; k < index - in; k++) {
		// if (arr[k] > arr[k + 1]) {
		// // ����
		// swap(k, k + 1);
		// }
		// }
		// // last-first
		// // index - in - 1 ����1��Ϊÿ��ִ�е��������һ����������ɣ����Լ�ȥ��,���ڱ�ʾ���û�����
		// for (int j = index - in - 1; j > in; j--) {
		// if (arr[j] < arr[j - 1]) {
		// // ����
		// swap(j, j - 1);
		// }
		//
		// }
		// }
		int i, left = 0, right = aElems - 1;
		int temp;
		while (left < right) {
			for (i = left; i < right; i++)
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			right--;
			for (i = right; i > left; i--)
				if (arr[i - 1] > arr[i]) {
					temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			left++;
		}
	}

	/**
	 * ��ż����
	 */
	public void oddEvenSort() {
		boolean flag = false;
		while (!flag) {
			flag = true;
			// û�н��в��������˳�ѭ��
			// ��������
			for (int i = 0; i < aElems - 1; i += 2) {
				if (arr[i] > arr[i + 1]) {
					// ��������
					arr[i] = arr[i + 1] + 0 * (arr[i + 1] = arr[i]);
					flag = false;
				}
			}
			// ż������
			for (int k = 1; k < aElems - 1; k += 2) {
				if (arr[k] > arr[k + 1]) {
					arr[k] = arr[k + 1] + 0 * (arr[k + 1] = arr[k]);
					flag = false;
				}
			}

		}
	}

	/**
	 * ѡ������
	 */
	public void selectSort() {
		int min;
		for (int out = 0; out < aElems - 1; out++) {// �������Ƚ�
			min = out;
			for (int in = out + 1; in < aElems; in++) {// ÿ�αȽϺ����Ĺ̶���,��ȥ�̶���i
				if (arr[in] < arr[min]) {
					min = in;
				}
			}
			swap(out, min);

		}
	}

	/**
	 * ��������
	 */
	public void insertSort() {
		// int out, in;
		// for (out = 1; out < aElems; out++) {
		// int temp = arr[out];// ��ʱ�洢
		// in = out;
		// while (in > 0 && arr[in - 1] >= temp) {
		// arr[in] = arr[in - 1];
		// --in;
		// }
		// arr[in] = temp;// ������ʱ�洢������
		// }

		int swapCount = 0;// �Ƚϴ���
		int copyCount = 0;// ���ƴ���

		int out, in;
		for (out = 1; out < aElems; out++) {
			int temp = arr[out];// ��ʱ�洢
			in = out;
			while (arr[in - 1] >= temp) {
				swapCount++;
				copyCount++;
				arr[in] = arr[in - 1];
				--in;
				if (in == 0) {
					break;
				}

			}
			copyCount++;
			arr[in] = temp;// ������ʱ�洢������
		}
		System.out.println(swapCount + " " + copyCount);
	}

	/**
	 * ����
	 * 
	 * @param i
	 * @param j
	 */
	public void swap(int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * ��ʾ
	 */
	public void display() {

		for (int i = 0; i < aElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/**
	 * ���������м�����ֵ
	 * 
	 * @return
	 */
	public void median() {
		// �ֱ������м�ֵ����С�ڶ��ٸ���
		int min = aElems / 2;
		int max = aElems - min;
		if (aElems % 2 == 1) {
			max -= 1;
		} else {
			min -= 1;
		}
		// ͳ��ÿ�����Ĵ���С�ڵ�ֵ�ø���
		for (int i = 0; i < aElems; i++) {
			int minCount = 0;
			int maxCount = 0;
			for (int k = 0; k < aElems; k++) {
				if (k == i)
					continue;
				else if (arr[i] > arr[k])
					minCount++;
				else if (arr[i] <= arr[k])
					maxCount++;
			}
			// ƥ����˵�����м�ֵ
			if (min == minCount && max == maxCount) {
				System.out.println("�м�ֵΪ��" + arr[i]);
				break;
			}
		}
	}

	/**
	 * ɾ���ظ�ֵ ��һ�����ͺ�����������Ƚϣ�������ͬ�ĺ����������ǰ�ƶ���Ϊ�˷�ֹ�ƶ��������Ƚϵ����ݣ�k--��z
	 */
	public void noDups() {
		for (int i = 0; i < aElems; i++) {
			for (int k = i + 1; k < aElems; k++) {
				if (arr[i] == arr[k]) {
					for (int j = k; j < aElems - 1; j++) {
						arr[j] = arr[j + 1];
					}
					k--;
					aElems--;
				}
			}
		}
	}

	/**
	 * ɾ���ظ���Ŀ 1:�ظ������-1 2���������飬���Ƶ�Դ�����С�
	 */
	public void noDups2() {
		// �ظ������Ϊ-1
		for (int i = 0; i < aElems; i++) {
			for (int k = 0; k < aElems; k++) {
				if (i == k)
					continue;
				if (arr[i] == arr[k]) {
					arr[k] = -1;
				}
			}
		}
		// ����������
		int[] arr1 = new int[arr.length];
		int ind = 0;
		int coun = 0;
		for (int j = 0; j < aElems; j++) {
			if (arr[j] == -1) {
				coun++;
				continue;

			}
			arr1[ind] = arr[j];
			ind++;
		}
		// ���������С�Լ���������
		aElems -= coun;
		for (int i = 0; i < aElems; i++) {
			arr[i] = arr1[i];
		}

	}

}
