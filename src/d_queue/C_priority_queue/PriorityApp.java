package d_queue.C_priority_queue;
/**
 * 优先级队列
 * @author Administrator
 *
 */
public class PriorityApp {
	public static void main(String[] args) {
		PriorityQ priorityQ=new PriorityQ(5);
		priorityQ.insert(10);
		priorityQ.insert(20);
		priorityQ.insert(50);
		priorityQ.insert(8);
		while(!priorityQ.isEmpty()){
			long item=priorityQ.remove();
			System.out.println(item);
		}
	}
}
