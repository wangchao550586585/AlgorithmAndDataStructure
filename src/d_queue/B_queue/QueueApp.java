package d_queue.B_queue;


/**
 * �������������
 * 
 * @�������ʱ���ͳ�ƺ�ʱ�����Ǽ���aElems��
 * 
 * @���Ƿ��֣�����������ж�����һ��
 * @��������������ʼ���Ķ��д�С�����йأ�������һֱ�㶨Ϊ0 ����Ϊ����֣����������ȶ���������1
 *
 * 
 * @author Administrator
 *
 */
public class QueueApp {
	public static void main(String[] args) {
		Queue theQueue = new Queue(8);
		theQueue.insert(12);
		theQueue.insert(32);
		theQueue.insert(43);
		theQueue.insert(53);
		theQueue.insert(65);

		theQueue.remove();
		theQueue.remove();
		theQueue.remove();
		theQueue.insert(76);
		theQueue.insert(23);
		theQueue.insert(21);

		theQueue.insert(34);
		theQueue.insert(54);
		theQueue.insert(76);

		System.out.println(theQueue.size());
		while (!theQueue.isEmpty()) {
			int i = theQueue.remove();
			System.out.print(i + " ");
		}
	}
}
