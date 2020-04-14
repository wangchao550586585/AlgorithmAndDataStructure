package k_graph.A_Graph.B_BFS;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;// 顶点数组
	private int adjMat[][];// 链接矩形
	private int nVerts;// 顶点个数
	private Queue theQueue;// 队列

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++)
			for (int j = 0; j < MAX_VERTS; j++)
				adjMat[i][j] = 0;
		theQueue = new Queue();
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
	 * 添加邻接矩阵
	 * 
	 * @param start
	 * @param end
	 */
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	/**
	 * 显示顶点
	 * 
	 * @param v
	 */
	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}

	/**
	 * 显示途径的
	 */
	public void bfs() { // breadth-frist-search 广度优先搜索
		vertexList[0].warVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v2 = 0;
		while (!theQueue.isEmpty()) {
			int v1 = theQueue.remove();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].warVisited = true;
				theQueue.insert(v2);
				displayVertex(v2);
			}
		}
		for (int i = 0; i < nVerts; i++)
			vertexList[i].warVisited = false;

	}

	/**
	 * 返回邻接顶点
	 * 
	 * @param v1
	 * @return
	 */
	public int getAdjUnvisitedVertex(int v1) {
		int i = -1;
		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v1][j] == 1 && vertexList[j].warVisited == false) {
				i = j;
				break;
			}
		}
		return i;
	}
}
