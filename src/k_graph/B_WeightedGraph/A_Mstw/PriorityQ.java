package k_graph.B_WeightedGraph.A_Mstw;

/**
 * 优先级队列 数组实现
 * 
 * @author Administrator
 * 
 */
public class PriorityQ {
	private final int SIZE = 20;
	private Edge[] queArray;
	private int size;

	public PriorityQ() {
		queArray = new Edge[SIZE];
		size = 0;
	}

	/**
	 * 插入边
	 * 
	 * @param item
	 */
	public void insert(Edge item) {

		int j;
		// 获取索引
		for (j = 0; j < size; j++)
			if (item.distance >= queArray[j].distance)
				break;
		for (int k = size - 1; k >= j; k--)
			queArray[k + 1] = queArray[k];

		queArray[j] = item;
		size++;
	}

	/**
	 * 删除边最小值
	 * 
	 * @return
	 */
	public Edge removeMin() {
		return queArray[--size];
	}

	/**
	 * 删除指定的边
	 * 
	 * @param n
	 */
	public void removeN(int n) {

		for (int j = n; j < size - 1; j++)
			queArray[j] = queArray[j + 1];
		size--;
	}

	/**
	 * 查看边最小值
	 * 
	 * @return
	 */
	public Edge peekMin() {

		return queArray[size - 1];
	}

	/**
	 * 查看指定的边
	 * 
	 * @param n
	 * @return
	 */
	public Edge peekN(int n) {
		return queArray[n];
	}

	/**
	 * 查询队列中到达findDex顶点边的索引
	 * 
	 * @param findDex
	 * @return
	 */
	public int find(int findDex) {

		int i = -1;
		for (int k = 0; k < size; k++)
			if (queArray[k].destVert == findDex) {
				i = k;
				break;
			}
		return i;
	}

	/**
	 * 返回个数
	 * 
	 * @return
	 */
	public int size() {

		return size;
	}

	/**
	 * 查看是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {

		return size == 0;
	}

}
