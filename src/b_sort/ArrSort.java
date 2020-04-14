package b_sort;

public class ArrSort {
	private int[] arr;
	private int aElems;

	public ArrSort(int max) {
		arr = new int[max];
		aElems = 0;
	}

	/**
	 * 添加数据
	 * 
	 * @param key
	 */
	public void insert(int key) {

		arr[aElems++] = key;
	}

	/**
	 * 冒泡排序
	 */
	public void buSort() {

		for (int i = 0; i < aElems - 1; i++) {// 几个数比较
			for (int k = 0; k < aElems - 1 - i; k++) {// 每次比较后后面的固定了,减去固定的i
				// for (int i = aElems - 1; i > 0; i--) {// 几个数比较
				// for (int k = 0; k < i; k++) {// 每次比较后后面的固定了,减去固定的i
				if (arr[k] > arr[k + 1]) {
					// 交换
					swap(k, k + 1);
				}

			}

		}
	}

	/**
	 * 双向冒泡(鸡尾酒排序)
	 */
	public void buSort1() {
		// int index = aElems - 1;
		// // 外层循环每次循环完毕能确定俩个数值，一个最大值一个最小值，所以循环次数减半，
		// // 如果数组长度为奇数时，最后一次循环将剩余一个数值，此值必为中间值，无需再排
		// // 列；如果数组长度为偶数时，循环 aElems / 2
		// for (int in = 0; in < aElems / 2; in++) {
		// // first-last
		// // index - in以内及包括，都没排序
		// for (int k = in; k < index - in; k++) {
		// if (arr[k] > arr[k + 1]) {
		// // 交换
		// swap(k, k + 1);
		// }
		// }
		// // last-first
		// // index - in - 1 后面1因为每次执行到这里最后一个数排序完成，所以减去它,现在表示最后没排序的
		// for (int j = index - in - 1; j > in; j--) {
		// if (arr[j] < arr[j - 1]) {
		// // 交换
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
	 * 奇偶排序
	 */
	public void oddEvenSort() {
		boolean flag = false;
		while (!flag) {
			flag = true;
			// 没有进行操作，则退出循环
			// 奇数排序
			for (int i = 0; i < aElems - 1; i += 2) {
				if (arr[i] > arr[i + 1]) {
					// 交换变形
					arr[i] = arr[i + 1] + 0 * (arr[i + 1] = arr[i]);
					flag = false;
				}
			}
			// 偶数排序
			for (int k = 1; k < aElems - 1; k += 2) {
				if (arr[k] > arr[k + 1]) {
					arr[k] = arr[k + 1] + 0 * (arr[k + 1] = arr[k]);
					flag = false;
				}
			}

		}
	}

	/**
	 * 选择排序
	 */
	public void selectSort() {
		int min;
		for (int out = 0; out < aElems - 1; out++) {// 几个数比较
			min = out;
			for (int in = out + 1; in < aElems; in++) {// 每次比较后后面的固定了,减去固定的i
				if (arr[in] < arr[min]) {
					min = in;
				}
			}
			swap(out, min);

		}
	}

	/**
	 * 插入排序
	 */
	public void insertSort() {
		// int out, in;
		// for (out = 1; out < aElems; out++) {
		// int temp = arr[out];// 临时存储
		// in = out;
		// while (in > 0 && arr[in - 1] >= temp) {
		// arr[in] = arr[in - 1];
		// --in;
		// }
		// arr[in] = temp;// 插入临时存储的数据
		// }

		int swapCount = 0;// 比较次数
		int copyCount = 0;// 复制次数

		int out, in;
		for (out = 1; out < aElems; out++) {
			int temp = arr[out];// 临时存储
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
			arr[in] = temp;// 插入临时存储的数据
		}
		System.out.println(swapCount + " " + copyCount);
	}

	/**
	 * 交换
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
	 * 显示
	 */
	public void display() {

		for (int i = 0; i < aElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 返回数组中间索引值
	 * 
	 * @return
	 */
	public void median() {
		// 分别计算出中间值大于小于多少个数
		int min = aElems / 2;
		int max = aElems - min;
		if (aElems % 2 == 1) {
			max -= 1;
		} else {
			min -= 1;
		}
		// 统计每个数的大于小于的值得个数
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
			// 匹配则说明是中间值
			if (min == minCount && max == maxCount) {
				System.out.println("中间值为：" + arr[i]);
				break;
			}
		}
	}

	/**
	 * 删除重复值 第一个数和后面的所有数比较，遇到相同的后面的数据向前移动，为了防止移动后跳过比较的数据，k--；z
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
	 * 删除重复项目 1:重复项更改-1 2：存新数组，复制到源数组中。
	 */
	public void noDups2() {
		// 重复项更改为-1
		for (int i = 0; i < aElems; i++) {
			for (int k = 0; k < aElems; k++) {
				if (i == k)
					continue;
				if (arr[i] == arr[k]) {
					arr[k] = -1;
				}
			}
		}
		// 存新数组中
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
		// 更改数组大小以及复制数组
		aElems -= coun;
		for (int i = 0; i < aElems; i++) {
			arr[i] = arr1[i];
		}

	}

}
