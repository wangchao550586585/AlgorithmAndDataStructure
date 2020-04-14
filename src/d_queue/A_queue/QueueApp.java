package d_queue.A_queue;

/**
 * �����������
 * 
 * @���У�������������ʱ��rear����-1����aElemsû���κδ��?��Ȼ���ӣ�removeʱ���ѭ����ʾ
 * 
 * @insert Ӧ���ж���û���������׳��쳣
 * @insert:(���ж��Ƿ�Ϊĩβ��Ϊ�Ļ���rear����-1)rear+1�����
 * @remove ���ж��Ƿ�Ϊ�գ��������׳��쳣
 * @remove��front��ɾ����+1(+1�����ж��Ƿ�Ϊĩβ��Ϊ��front����0)
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
		theQueue.insert(76);
		theQueue.insert(23);
		theQueue.insert(21);

		theQueue.remove();
		theQueue.remove();
		theQueue.insert(34);
		theQueue.insert(54);
		theQueue.insert(76);

		theQueue.display();
		// System.out.println(theQueue.size());
		// while (!theQueue.isEmpty()) {
		// int i = theQueue.remove();
		// System.out.print(i + " ");
		// }
	}
}
