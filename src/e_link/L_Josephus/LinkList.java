package e_link.L_Josephus;

public class LinkList {
	Link current;
	Link previous;
	Link first;
	Link last;

	public LinkList() {
		current = null;
		previous = null;
		first = null;
		last = null;
	}

	public void insertFirst(int k) {
		Link newLink = new Link(k);
		if (isEmpty())
			last = newLink;
		else
			first.previous = newLink;
		newLink.next = first;
		first = newLink;
		last.next = first;
	}

	public void reset() {
		current = first;
		previous = last;
	}

	/**
	 * ��һ���ڵ�
	 */
	public void nextLink() {
		previous = current;
		current = current.next;
	}

	/**
	 * ��ȡ��ǰ�ڵ�
	 * 
	 * @return
	 */
	public Link getCurrent() {
		return current;
	}

	/**
	 * ɾ����ǰ�ڵ�
	 * 
	 * @current Ϊĩβ�Ļ���reset()����currentΪɾ����һ���ڵ�
	 */
	public int deleteCurrent() {
		int temp = current.iData;
		previous = current;
		current = previous;
		return temp;
	}

	public void displayForward() {
		Link current = first;
		current.displayLink();
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return first == null;
	}
}
