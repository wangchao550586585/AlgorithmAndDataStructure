package d_queue.C1_priority_queue;

/**
 * ���ȼ����� ����O(1)��ɾ����
 * 
 * @author Administrator
 * 
 */
public class PriorityApp {
	public static void main(String[] args) {
		PriorityQ priorityQ = new PriorityQ(5);
		priorityQ.insert(90);
		priorityQ.insert(10);
		priorityQ.insert(20);
		priorityQ.insert(50);
		priorityQ.insert(8);

		while (!priorityQ.isEmpty()) {
			long item = priorityQ.remove();
			System.out.println(item);
		}
	}
}
