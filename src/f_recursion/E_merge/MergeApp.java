package f_recursion.E_merge;

/**
 * 归并排序
 * 
 * @author Administrator
 * 
 */
public class MergeApp {
	public static void main(String[] args) {
		int[] arrA = { 23, 34, 45, 66 };
		int[] arrB = { 20, 30, 40, 50, 60, 70 };
		int[] arrC = new int[10];

		merge(arrA, 4, arrB, 6, arrC);
		display(arrC, 10);

	}

	private static void display(int[] arrC, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(arrC[i]);
		}

	}

	private static void merge(int[] arrA, int sizeA, int[] arrB, int sizeB,
			int[] arrC) {
		int aDex = 0;
		int bDex = 0;
		int cDex = 0;

		while (aDex < sizeA && bDex < sizeB) {// 处理a和B都不空的情况
			if (arrA[aDex] < arrB[bDex]) {
				arrC[cDex++] = arrA[aDex++];
			} else {
				arrC[cDex++] = arrB[bDex++];
			}
		}
		while (aDex < sizeA) {// 处理a数组没空，b数组空的情况
			arrC[cDex++] = arrA[aDex++];
		}
		while (bDex < sizeB) {// 处理b数组没空,a数组空的情况
			arrC[cDex++] = arrB[bDex++];
		}

	}

}
