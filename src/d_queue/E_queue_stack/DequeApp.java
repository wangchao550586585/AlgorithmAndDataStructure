package d_queue.E_queue_stack;

/**
 * ˫�˶��� ֧�ֻ���ʽ
 * 
 * @author Administrator
 * 
 */
public class DequeApp {
	public static void main(String[] args) {
		Deque theDeque = new Deque(8);
		theDeque.push(453);
		theDeque.push(453);
		theDeque.push(4);
		theDeque.push(453);
		theDeque.push(417);
		theDeque.push(173);

		// theDeque.insertRight(103);
		// theDeque.insertRight(3);

		while (!theDeque.isEmpty()) {
			System.out.println(theDeque.pop());
		}
	}
}
