package e_link.I_priorityQue;

public class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public int deleteMin() {
		int temp = first.iData;
		first = first.next;
		return temp;
	}

	public void insert(int iData) {
		Link newLink = new Link(iData);
		Link current = first;
		Link previous = null;
		// �ж��Ƿ�Ϊ��
		while (current != null && current.iData < iData) {// ѭ���õ���ŵ�λ��
			previous = current;
			current = current.next;
		}
		if (previous != null)// ˵��current��first����
			previous.next = newLink;
		else
			// ˵��current����first
			first = newLink;
		newLink.next = current;
		
		
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void displayLink() {
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
}
