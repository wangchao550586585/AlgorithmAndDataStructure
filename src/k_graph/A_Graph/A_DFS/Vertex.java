package k_graph.A_Graph.A_DFS;

/**
 * 顶点
 * 
 * @author Administrator
 *
 */
public class Vertex {
	public char label;
	public boolean wasVisited;// false表示没有找到，true表示找到

	public Vertex(char label) {
		this.label = label;
		wasVisited = false;
	}

}
