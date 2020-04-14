package k_graph.B_WeightedGraph.A_Mstw;

public class Graph {
	private final int MAX_VERTS = 20;// 个数
	private final int INFINIITY = 1000000;// 默认距离
	private Vertex vertexList[];// 顶点数组
	private int adjMat[][];// 关联边
	private int nVerts;// 现在顶点个数
	private int currentVerts;// 现在顶点
	private PriorityQ thePQ;// 优先级队列
	private int nTree;// 树个数

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		thePQ = new PriorityQ();
		for (int i = 0; i < MAX_VERTS; i++)
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[i][k] = INFINIITY;
	}

	/**
	 * 添加顶点
	 * 
	 * @param lab
	 */
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	/**
	 * 添加边长
	 * 
	 * @param start
	 *            行
	 * @param end
	 *            列
	 * @param weight
	 *            distance 距离
	 * 
	 */
	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}

	public void displayVertex(int src, int currentVer) {
		System.out.println(vertexList[src].label +""+ vertexList[currentVer].label );
	}

	/**
	 * minimum spanning tree 最小生成树
	 */
	public void mstw() {
		currentVerts = 0;// 现在顶点索引
		while (nTree < nVerts - 1) {// 树个数小于顶点个数时循环,退出循环条件，2者等于，说明全部添加到树中
			vertexList[currentVerts].isInTree = true;// 存放树中
			nTree++;// 树个数增加
			for (int i = 0; i < nVerts; i++) {// 一行中查找
				// 源点和顶点相同，
				if (i == currentVerts)
					continue;
				// 判断顶点在不在树中
				if (vertexList[i].isInTree)
					continue;
				int distance = adjMat[currentVerts][i];// 获取2边间隔
				if (distance == INFINIITY)// 距离为默认值则跳过
					continue;
				putInPQ(i, distance);// 存放优先级队列中
			}
			// 优先级队列个数为0，则不流通图，退出
			if (thePQ.size() == 0) {
				System.out.println("循环图");
				return;
			}
			Edge theEdge = thePQ.removeMin();// 删除最小边
			int srcVert = theEdge.srcVert;
			currentVerts = theEdge.destVert;// 设置现在的顶点索引
			displayVertex(srcVert,currentVerts);
		}
		// isInTree重置
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isInTree = false;
		}
	}

	/**
	 * 放入队列中
	 * 
	 * @param newVert
	 * @param newDist
	 */
	public void putInPQ(int newVert, int newDist) {
		int queueIndex = thePQ.find(newVert);// 查询队列中到达newVert顶点的边索引
		if (queueIndex != -1) {
			Edge tempEdge = thePQ.peekN(queueIndex);// 根据索引获得边
			int oldDistance = tempEdge.distance;
			
			// 此操作保证开始点到终点只有最小的边存在于队列
			if (oldDistance > newDist) {// 比较距离之前的比现在的大的话，删除之前的，否则不添加。
				thePQ.removeN(queueIndex);
				Edge theEdge = new Edge(currentVerts, newVert, newDist);
				thePQ.insert(theEdge);
			}
		} else {
			Edge theEdge = new Edge(currentVerts, newVert, newDist);
			thePQ.insert(theEdge);
		}
	}
}
