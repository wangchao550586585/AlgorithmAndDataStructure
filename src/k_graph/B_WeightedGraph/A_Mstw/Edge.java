package k_graph.B_WeightedGraph.A_Mstw;

/**
 * 边
 * 
 * @author Administrator 
 *
 */ 
public class Edge {
	public int srcVert;// 顶点开始边索引
	public int destVert;// 顶点结尾边索引
	public int distance;// 距离

	public Edge(int srcVert, int destVert, int distance) {
		super();
		this.srcVert = srcVert;
		this.destVert = destVert;
		this.distance = distance;
	}

}
