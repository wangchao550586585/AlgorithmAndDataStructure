package k_graph.A_Graph.C_MST;
/**
 * 无向图
 * 最小化生成树
 * @author Administrator
 *
 */
public class MSTApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();

		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		theGraph.addVertex('G');
		theGraph.addVertex('H');
		theGraph.addVertex('I');

		theGraph.addEdge(0, 1);
		theGraph.addEdge(0, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(1, 4);
		theGraph.addEdge(1, 5);
		theGraph.addEdge(2, 5);
		theGraph.addEdge(2, 6);
		theGraph.addEdge(6, 7);
		theGraph.addEdge(3, 8);
		
		theGraph.mst();
	}
}
