package k_graph.B_WeightedGraph.B_Path;

public class DistPar {// 距离父节点
	public int distance;// 距离
	public int parentVert;// 顶点父节点索引

	public DistPar(int parentVert, int distance) {
		this.parentVert = parentVert;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "DistPar [distance=" + distance + ", parentVert=" + parentVert
				+ "]";
	}

}
