package e_link.I_priorityQue;

/**
 * ���ȼ���������ʵ��
 * 
 * @author Administrator
 * 
 */
public class QueueSort {
	private LinkList theLinkList;

	public QueueSort() {
		theLinkList = new LinkList();
	}

	public void insert(int i) {
		theLinkList.insert(i);
	}

	public int remove() {
		int temp = theLinkList.deleteMin();
		return temp;
	}

	public void displayList() {
		theLinkList.displayLink();
	}
}
