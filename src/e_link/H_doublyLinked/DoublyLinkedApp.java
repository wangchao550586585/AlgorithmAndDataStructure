package e_link.H_doublyLinked;

/**
 * 双向链表,允许前后遍历
 * 
 * @author Administrator
 */
public class DoublyLinkedApp {
	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();
		theList.insertFirst(10);
		theList.insertFirst(20);
		theList.insertFirst(30);
		theList.insertLast(80);
		theList.insertLast(90);
		theList.insertLast(100);
		theList.insertAfter(30, 40);
		theList.insertAfter(30, 60);
		theList.displayForward();
		System.out.println();
		theList.displayBackward();
		System.out.println();

		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(60);
		theList.displayForward();
		System.out.println();
		theList.displayBackward();
	}
}
