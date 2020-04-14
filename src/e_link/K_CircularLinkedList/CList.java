package e_link.K_CircularLinkedList;

public class CList {
	Link current;
	FirstLastLink fll;

	public CList() {
		fll = new FirstLastLink();
		reset();
	}

	public void insert(int k) {
		fll.insertFirst(k);
		reset();
	}

	public void reset() {
		current = fll.getFirst();
	}

	public Link step() {
		current = current.next;
		return current;
	}
}
