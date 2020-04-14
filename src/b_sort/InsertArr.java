package b_sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * ��������:�������
 * �ұߺ���߱Ƚϣ������С����Ի�
 * @author Administrator
 *
 */
public class InsertArr {
	public void insertSort(long[] arr) {
		int in, out;
		for (out = 1; out < arr.length; out++) {
			long temp = arr[out];
			in = out;
			while (in > 0 && arr[in - 1] >=temp) {
				arr[in] = arr[in - 1];
				--in;
			}
			arr[in] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public void fun(){
		insertSort(new long[]{10,11,8,20,7});
	}

}
