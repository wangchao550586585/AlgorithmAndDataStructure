package g_advancedSort.B_partition;

/**
 * 划分:数据分成2组，大于关键字的右边，小于关键字的左边。
 * 
 * @author Administrator
 *
 */
public class PartitionApp {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayPar arr = new ArrayPar(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (int) (Math.random() * 199);
			arr.insert(n);
		}
		arr.displays();
		
		
		long pivot = 99;
		System.out.println("Pivot = " + pivot);
		int size = arr.size();
		
		/*
		 *返回，小于99的个数，也就是从多少位开始划分 
		 */
		int partDex = arr.partitionIt(0, size - 1, pivot);

		System.out.println("Partition index =" + partDex);
		arr.displays();
	}
}
