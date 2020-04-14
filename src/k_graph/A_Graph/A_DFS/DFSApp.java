package k_graph.A_Graph.A_DFS;

/**
 * 无向图
 * 深度优先搜索(DFS)
 * 
 * @author Administrator
 *
 */
public class DFSApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');


		theGraph.addEage(0, 1);//A-B
		theGraph.addEage(1, 2);//B-C
		theGraph.addEage(0, 3);//C-D
		theGraph.addEage(3, 4);//D-E
		theGraph.addEage(3, 5);//D-F


		System.out.print("Visits: ");
		theGraph.dfs();
	}
}
