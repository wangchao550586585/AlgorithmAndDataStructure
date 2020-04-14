package k_graph.A_Graph.D_DAG;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVerts;
	private char sortArray[];

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		sortArray = new char[MAX_VERTS];
		for (int i = 0; i < MAX_VERTS; i++)
			for (int j = 0; j < MAX_VERTS; j++)
				adjMat[i][j] = 0;
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
	}

	/**
	 * 拓扑排序
	 */
	public void topo() {
		int orig_nVerts = nVerts;
		while (nVerts > 0) {
			// 获取后继顶点
			int currentVerts = noSuccessors();// 查找无后继的顶点
			if (currentVerts == -1) {
				System.out.println("ERROR：Graph has cycles/错误，图为循环 ");
				return;
			}
			sortArray[nVerts - 1] = vertexList[currentVerts].label;// 入数组，从后往前存
			deleteVertex(currentVerts);// 删除顶点
		}
		// 遍历
		System.out.println("拓扑排序:");
		// 从前显示后面
		for (int j = 0; j < orig_nVerts; j++) {
			System.out.print(sortArray[j] + " ");
		}

	}

	/**
	 * 查找无后继的顶点
	 * 
	 * @return
	 */
	public int noSuccessors() {
		boolean isEdge;
		int index = -1;
		for (int row = 0; row < nVerts; row++) {
			isEdge = false;
			for (int col = 0; col < nVerts; col++) {
				// 当邻接矩阵里面含有大于0的数据项，说明此行没有后继顶点，结束
				if (adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			// 当邻接矩阵没有大于0的数据项，说明无后继顶点
			if (!isEdge) {
				index = row;
				break;
			}
		}
		return index;
	}

	/**
	 * 删除顶点
	 * 
	 * @param delVert
	 *            delVert:无后继的顶点 nVe:顶点个数
	 *            因为每次删除无后继所在的行列,顶点个数也会删除，到了最后无后继所在索引为0,而顶点个数为1。 nVerts -
	 *            1说明最后一个
	 */
	public void deleteVertex(int delVert) {
		if (delVert != nVerts - 1) {// 如果不是最后一个
			// 删除顶点，顶点数组前移
			for (int j = delVert; j < nVerts - 1; j++) {
				vertexList[j] = vertexList[j + 1];
			}
			// 删除邻接矩阵行
			for (int row = delVert; row < nVerts - 1; row++) {
				moveRowUp(row, nVerts);
			}
			// 删除列,这里nVerts - 1之所有减1，是因为前面删除了一行
			for (int col = delVert; col < nVerts - 1; col++) {
				moveColLeft(col, nVerts - 1);
			}
		}

		nVerts--;
	}

	/**
	 * 删除行: 行向上移动一索引
	 * 
	 * @param col
	 * @param length
	 */
	private void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++) {
			// row + 1 ，行向上移动，覆盖，起到删除的效果
			adjMat[row][col] = adjMat[row][col + 1];
		}
	}

	/**
	 * 删除列: 列向左移动一索引
	 * 
	 * @param col
	 * @param length
	 */
	private void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++) {
			// row + 1 ，行向上移动，覆盖，起到删除的效果
			adjMat[row][col] = adjMat[row + 1][col];
		}
	}
}
