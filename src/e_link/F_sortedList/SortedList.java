package e_link.F_sortedList;

public class SortedList {
	public Link first;

	public SortedList() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insert(long key) {
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		while (current != null && key > current.data) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			first = newLink;
		} else {
			previous.next = newLink;
		}
		newLink.next = current;
	}

	public Link remove() {
		Link link = first;
		first = first.next;
		return link;
	}

	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}

	}

}
