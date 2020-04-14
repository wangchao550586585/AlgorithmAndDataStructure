package d_queue.D_DoubleQue;

/**
 * ˫�˶��� ֧�ֻ���ʽ
 * 
 * @author Administrator
 * 
 */
public class DequeApp {
	public static void main(String[] args) {
		Deque theDeque = new Deque(8);
		theDeque.insertRight(453);
		theDeque.insertRight(453);
		theDeque.insertRight(4);
		theDeque.insertRight(453);
		theDeque.insertRight(417);
		theDeque.insertRight(173);

		theDeque.insertLeft(453);
		theDeque.insertLeft(453);

		// theDeque.insertRight(103);
		// theDeque.insertRight(3);

		while (!theDeque.isEmpty()) {
			System.out.println(theDeque.removeRight());
		}
	}
}
