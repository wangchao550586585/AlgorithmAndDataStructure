package k_graph.B_WeightedGraph.B_Path;

/**
 * 寻找距离最近的顶点，利用最小更新路径数组中的父顶点和距离,循环。就都是最小路径了
 * 
 * @author Administrator
 * 
 */
public class Graph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private int nTree;
	private DistPar sPath[];// 最短路径数据数组
	private int currentVert;// 现在的顶点
	private int startToCurrent;// 现在顶点距离

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree=0;
		sPath = new DistPar[MAX_VERTS];
		for (int i = 0; i < MAX_VERTS; i++)
			for (int j = 0; j < MAX_VERTS; j++)
				adjMat[i][j] = INFINITY;
	}

	public void addVertex(char lab) {

		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end, int weight) {

		adjMat[start][end] = weight;
	}

	/**
	 * 找到所有最短路径
	 */
	public void path() {
		int startTree = 0;// 开始顶点在0
		vertexList[startTree].isInTree = true;
		nTree++;// 放入树
		// 开始点到各顶点的所有距离，放入spath数组。
		for (int j = 0; j < nVerts; j++) {
			// 获取距离
			int tempDist = adjMat[startTree][j];
			sPath[j] = new DistPar(startTree, tempDist);
		}
		while (nTree < nVerts) {
			// 获取最小距离对应顶点的索引
			int indexMin = getMin();
			// 获取最小距离
			int minDist = sPath[indexMin].distance;
			// 等于INFINITY说明，到所有顶点距离都遥不可及
			if (minDist == INFINITY) {
				System.out.println("有遥不可及的顶点");
				break;

			} else {
				// 现在顶点为最小距离索引
				currentVert = indexMin;
				// 现在距离为最小距离
				startToCurrent = minDist;

			}
			// 加入树
			vertexList[currentVert].isInTree = true;
			nTree++;

			// 更新距离和顶点
			adjust_sPath();
		}
		displayPaths();
		nTree = 0;
		for (int j = 0; j < nVerts; j++) {
			vertexList[j].isInTree = false;
		}
	}

	public void displayPaths() {
		for (int i = 0; i < nVerts; i++) {
			System.out.print(vertexList[i].label + "=");
			if (sPath[i].distance == INFINITY)
				System.out.print("inf");
			else
				System.out.print(sPath[i].distance);
			char parent = vertexList[sPath[i].parentVert].label;
			System.out.print("(" + parent + ") "+" ");
		}
		
	}

	/**
	 * 更新距离和顶点
	 */
	public void adjust_sPath() {

		int column = 1;
		while (column < nVerts) {
			// 跳过已经在树的节点
			if (vertexList[column].isInTree) {
				column++;
				continue;
			}
			// 获取现在节点到树内的其他顶点的距离
			int currentToFringe = adjMat[currentVert][column];
			// 获取最新的距离
			int startToFrige = startToCurrent + currentToFringe;
			// 取出数组之前的距离
			int sPathDist = sPath[column].distance;
			// 比较
			if (startToFrige < sPathDist) {
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFrige;
			}
			column++;
		}

	}

	/**
	 * 获取最小值索引
	 * 
	 * @return
	 */
	public int getMin() {

		int minDist = INFINITY;// 暂定最小值为INFINITY无穷大
		int indexMin = 0;
		for (int j = 1; j < nVerts; j++) {
			// 没被访问同时距离<最小距离
			if (!vertexList[j].isInTree && sPath[j].distance < minDist) {
				minDist = sPath[j].distance;// 获取小值，赋值，下次拿这个小值和更小值比较，方便获取最小值索引
				indexMin = j;
			}
		}
		return indexMin;
	}

}
