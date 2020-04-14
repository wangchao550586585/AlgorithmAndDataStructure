package e_link.J_FirstLastQue;

public class Deque {
	private DoublyLinkedList theDL;

	public Deque() {
		theDL = new DoublyLinkedList();
	}

	public void insertLeft(int key) {
		theDL.insertFirst(key);
	}

	public void insertRight(int key) {
		theDL.insertLast(key);
	}

	public int removeLeft() {
		int temp = theDL.deleteLast();
		return temp;
	}

	public int removeRight() {
		int temp = theDL.deleteFirst();
		return temp;
	}

	public boolean isEmpty() {
		return theDL.isEmpty();
	}

}
