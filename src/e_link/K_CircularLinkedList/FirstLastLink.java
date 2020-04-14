package e_link.K_CircularLinkedList;

/**
 * 循环链表
 * 
 * @author Administrator
 *
 */
public class FirstLastLink {
	private Link first;
	private Link last;

	public FirstLastLink() {
		first = null;
		last = null;
	}

	public Link getFirst() {
		return first;
	}
	
	public Link getLast() {
		return last;
	}


	public void insertFirst(int iData) {
		Link newLink = new Link(iData);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(int iData) {
		Link newLink = new Link(iData);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		// 循环链表
		newLink.next = first;
		last = newLink;
	}

	public int deleteFirst() {
		int temp = first.iData;
		if (first.next == null)
			last = null;
		first = first.next;
		return temp;
	}

	public void displayLink() {
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

}
