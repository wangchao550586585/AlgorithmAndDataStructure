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
		// 判断是否为空
		while (current != null && current.iData < iData) {// 循环得到存放的位置
			previous = current;
			current = current.next;
		}
		if (previous != null)// 说明current在first后面
			previous.next = newLink;
		else
			// 说明current就是first
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
