package k_graph.A_Graph.C_MST;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private StackX theStackX;

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		theStackX = new StackX();

		for (int i = 0; i < MAX_VERTS; i++) {
			for (int k = 0; k < MAX_VERTS; k++) {
				adjMat[i][k] = 0;
			}
		}
	}

	public void addVertex(char lab) {

		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {

		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int j) {

		System.out.print(vertexList[j].label);
	}

	public void mst() {
		vertexList[0].wasVisited = true;
		theStackX.push(0);
		while (!theStackX.isEmpty()) {
			int currentVertex = theStackX.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v != -1) {
				vertexList[v].wasVisited = true;
				theStackX.push(v);

				// 输出邻接2顶点的值
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.println();
			} else
				theStackX.pop();
		}
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}

	public int getAdjUnvisitedVertex(int v) {

		int i = -1;
		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				i = j;
				break;
			}
		}
		return i;
	}
}
