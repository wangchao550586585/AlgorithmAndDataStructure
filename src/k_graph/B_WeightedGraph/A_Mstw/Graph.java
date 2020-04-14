package k_graph.B_WeightedGraph.A_Mstw;

public class Graph {
	private final int MAX_VERTS = 20;// ����
	private final int INFINIITY = 1000000;// Ĭ�Ͼ���
	private Vertex vertexList[];// ��������
	private int adjMat[][];// ������
	private int nVerts;// ���ڶ������
	private int currentVerts;// ���ڶ���
	private PriorityQ thePQ;// ���ȼ�����
	private int nTree;// ������

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		thePQ = new PriorityQ();
		for (int i = 0; i < MAX_VERTS; i++)
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[i][k] = INFINIITY;
	}

	/**
	 * ��Ӷ���
	 * 
	 * @param lab
	 */
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	/**
	 * ��ӱ߳�
	 * 
	 * @param start
	 *            ��
	 * @param end
	 *            ��
	 * @param weight
	 *            distance ����
	 * 
	 */
	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}

	public void displayVertex(int src, int currentVer) {
		System.out.println(vertexList[src].label +""+ vertexList[currentVer].label );
	}

	/**
	 * minimum spanning tree ��С������
	 */
	public void mstw() {
		currentVerts = 0;// ���ڶ�������
		while (nTree < nVerts - 1) {// ������С�ڶ������ʱѭ��,�˳�ѭ��������2�ߵ��ڣ�˵��ȫ����ӵ�����
			vertexList[currentVerts].isInTree = true;// �������
			nTree++;// ����������
			for (int i = 0; i < nVerts; i++) {// һ���в���
				// Դ��Ͷ�����ͬ��
				if (i == currentVerts)
					continue;
				// �ж϶����ڲ�������
				if (vertexList[i].isInTree)
					continue;
				int distance = adjMat[currentVerts][i];// ��ȡ2�߼��
				if (distance == INFINIITY)// ����ΪĬ��ֵ������
					continue;
				putInPQ(i, distance);// ������ȼ�������
			}
			// ���ȼ����и���Ϊ0������ͨͼ���˳�
			if (thePQ.size() == 0) {
				System.out.println("ѭ��ͼ");
				return;
			}
			Edge theEdge = thePQ.removeMin();// ɾ����С��
			int srcVert = theEdge.srcVert;
			currentVerts = theEdge.destVert;// �������ڵĶ�������
			displayVertex(srcVert,currentVerts);
		}
		// isInTree����
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isInTree = false;
		}
	}

	/**
	 * ���������
	 * 
	 * @param newVert
	 * @param newDist
	 */
	public void putInPQ(int newVert, int newDist) {
		int queueIndex = thePQ.find(newVert);// ��ѯ�����е���newVert����ı�����
		if (queueIndex != -1) {
			Edge tempEdge = thePQ.peekN(queueIndex);// ����������ñ�
			int oldDistance = tempEdge.distance;
			
			// �˲�����֤��ʼ�㵽�յ�ֻ����С�ıߴ����ڶ���
			if (oldDistance > newDist) {// �ȽϾ���֮ǰ�ı����ڵĴ�Ļ���ɾ��֮ǰ�ģ�������ӡ�
				thePQ.removeN(queueIndex);
				Edge theEdge = new Edge(currentVerts, newVert, newDist);
				thePQ.insert(theEdge);
			}
		} else {
			Edge theEdge = new Edge(currentVerts, newVert, newDist);
			thePQ.insert(theEdge);
		}
	}
}
