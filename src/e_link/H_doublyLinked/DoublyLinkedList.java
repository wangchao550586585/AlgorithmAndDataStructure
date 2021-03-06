package e_link.H_doublyLinked;

public class DoublyLinkedList {
	private Link first;
	private Link last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public Link deleteFirst() {
		Link temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}

	public Link deleteLast() {
		Link temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}

	/*
	 * 在key后面添加数据
	 */
	public boolean insertAfter(long key, long dd) {
		Link current = first;
		while (current.data != key) {
			current = current.next;
			if (current == null)
				return false;
		}
		Link newLink = new Link(dd);
		if (current == last) {
			newLink.next = null;
			last = newLink;
		} else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}

	/*
	 * 删除值为key的对象
	 */
	public Link deleteKey(long key) {
		Link current = first;
		while (current.data != key) {
			current = current.next;
			if (current == null)
				return null;
		}
		//干掉前面
		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}
		//连接后面
		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current;
	}

	public void displayForward() {
		Link link = first;
		while (link != null) {
			link.displayLink();
			link = link.next;
		}
	}

	public void displayBackward() {
		Link link = last;
		while (link != null) {
			link.displayLink();
			link = link.previous;
		}
	}
}
