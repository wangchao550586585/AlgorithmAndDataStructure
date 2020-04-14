package e_link.J_FirstLastQue;

public class DoublyLinkedList {
	private Link first;
	private Link last;

	public DoublyLinkedList() {
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
	}

	public void insertLast(int k) {
		Link newLink = new Link(k);
		if (isEmpty())
			first = newLink;
		else {
			newLink.previous = last;
			last.next = newLink;
		}
		last = newLink;
	}

	/**
	 * 值是key节点的后面添加dData
	 */
	public boolean insertAfter(int key, int dData) {
		Link newLink = new Link(dData);
		Link current = first;
		while (current != null) {
			if (current.iData == key)
				break;
			current = current.next;
		}
		boolean flag = true;
		if (current != null) {
			if (current == last) {
				newLink.next = null;
				last = newLink;
			} else {
				current.next.previous = newLink;
				newLink.next = current.next;
			}
			current.next = newLink;
			newLink.previous = current;
		} else {
			flag = false;
		}
		return flag;

	}

	/**
	 * 删除关键字为key的节点 考虑first和last
	 * 
	 * @param key
	 */
	public Link deleteKey(int key) {

		Link current = first;
		while (current != null) {
			if (current.iData == key)
				break;
			current = current.next;
		}
		// 连接后面
		if (current == first)
			first = current.next;
		else
			current.previous.next = current.next;
		// 连接前面
		if (current == last)
			last = current.previous;
		else
			current.next.previous = current.previous;
		return current;
	}

	public int deleteFirst() {
		Link temp = first;
		if (first.next == null) {
			last = null;
		} else {
			// first.previous = null;]
			first.next.previous = null;
		}
		// 提取共同点
		first = first.next;
		return temp.iData;
	}

	public int deleteLast() {
		Link temp = last;
		if (last.previous == null) {
			first = null;
		} else {
			// last.next = null;
			last.previous.next = null;
		}
		// 提取共同点
		last = last.previous;
		return temp.iData;
	}

	public void displayForward() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

	public void displayBackward() {
		Link current = last;
		while (current != null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return first == null;
	}
}
