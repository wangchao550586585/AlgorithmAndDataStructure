package e_link.G_listInsertionSort;

public class SortedList {
	private Link first;

	public SortedList() {
		first = null;
	}

	public SortedList(Link[] linkArr) {
		first = null;
		for (int j = 0; j < linkArr.length; j++) {
			insert(linkArr[j]);
		}
	}

	public void insert(Link link) {
		Link previous = null;
		Link current = first;
		while (current != null && link.data > current.data) {
			previous = current;
			current = current.next;
		}
		if (previous == null)
			first = link;
		else
			previous.next = link;
		link.next = current;
	}

	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}
}
