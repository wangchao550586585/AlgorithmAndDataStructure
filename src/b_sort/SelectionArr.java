package b_sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * ѡ������
 * 
 * @author Administrator
 *
 */
public class SelectionArr {
	public static void selectionSort(long[] arr) {
		int min;
		int k;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (k = i + 1; k < arr.length; k++) {
				if (arr[min] > arr[k]) {
					min = k;
				}
			}
			long temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

		}
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public static void main(String[] args) {
		selectionSort(new long[] { 17, 30, 27, 90, 190, 10, 11, 7 });
	}

}
