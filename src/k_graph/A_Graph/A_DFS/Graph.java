package k_graph.A_Graph.A_DFS;

/**
 * 图
 * 
 * @author Administrator
 *
 */
public class Graph {
	public final int MAX_VERTS = 20;//初始化顶点最多20个
	public Vertex vertexList[];// 顶点数组 list of vertices
	public int adjMat[][];// 邻接矩阵 adjacency matrix
	public int nVerts;// 当前顶点个数 current number of vertices
	public StackX theStackX;

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		theStackX = new StackX();
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
	 * 添加边
	 * 
	 * @param start
	 * @param end
	 */
	public void addEage(int start, int end) {
		//1表示互通
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	/**
	 * 显示对应索引的顶点值
	 * 
	 * @param v
	 */
	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}

	public void dfs() {// depth-first-serch深度优先搜索
		vertexList[0].wasVisited = true;
		displayVertex(0);
		// 下标入栈
		theStackX.push(0);
		// 深度搜索
		while (!theStackX.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStackX.peek());// 获取未访问的顶点
			if (v != -1) {
				// 更改访问状态
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStackX.push(v);
			} else
				theStackX.pop();

		}
		// 重置访问状态
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}

	}

	/**
	 * 查询未访问过得顶点
	 * 
	 * @param v
	 * @return
	 */
	public int getAdjUnvisitedVertex(int v) {
		int i = -1;
		for (int j = 0; j < nVerts; j++) {
			// adjMat[v][j] == 1说明有2顶点关联,同时从当前行寻找j循环的数据
			// vertexList[j].wasVisited == false说明顶点没访问
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				i = j;
				break;
			}
		}
		return i;
	}
}
