package e_link.J_FirstLastQue;

/**
 * 链表实现 双端队列
 * 
 * @author Administrator
 * 
 */
public class DequeApp {
	public static void main(String[] args) {
		Deque theDeque = new Deque();
		theDeque.insertRight(453);
		theDeque.insertRight(453);
		theDeque.insertRight(4);
		theDeque.insertRight(453);
		theDeque.insertRight(417);
		theDeque.insertRight(173);

		theDeque.insertLeft(453);
		theDeque.insertLeft(453);

		theDeque.removeLeft();
		theDeque.insertRight(103);
		theDeque.insertRight(3);

		while (!theDeque.isEmpty()) {
			System.out.print(theDeque.removeRight() + " ");
		}
	}
}
