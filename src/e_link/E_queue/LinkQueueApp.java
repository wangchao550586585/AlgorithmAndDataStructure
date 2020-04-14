package e_link.E_queue;

/**
 * 链表实现队列
 * 
 * @author Administrator
 *
 */
public class LinkQueueApp {
	public static void main(String[] args) {
		LinkQueue linkQueue = new LinkQueue();

		linkQueue.insert(10);
		linkQueue.insert(20);
		linkQueue.insert(30);

		linkQueue.displayQueue();
		
		linkQueue.insert(40);
		linkQueue.insert(50);
		linkQueue.insert(60);
		
		System.out.println("-------------");
		linkQueue.displayQueue();

		linkQueue.remove();
		linkQueue.remove();
		linkQueue.remove();
		linkQueue.remove();
		System.out.println("-------------");
		linkQueue.displayQueue();
	}
}
