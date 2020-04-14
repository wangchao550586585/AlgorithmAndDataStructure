package k_graph.B_WeightedGraph.A_Mstw;

public class Vertex {
	public char label;
	public boolean isInTree;// 是否在树中

	public Vertex(char label) {
		this.label = label;
		this.isInTree = false;
	}

}
