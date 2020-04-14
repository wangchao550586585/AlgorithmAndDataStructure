package e_link.I_priorityQue;

/**
 * 优先级队列,单向链表实现
 * 
 * @author Administrator
 * 
 */
public class Demo {
	public void fun1() {
		QueueSort theQs = new QueueSort();
		theQs.insert(15);
		theQs.insert(25);
		theQs.insert(97);
		theQs.insert(6);
		theQs.insert(7);
		theQs.insert(79);
		theQs.insert(32);
		theQs.insert(66);
		theQs.insert(1);
		theQs.displayList();
		System.out.println();
		theQs.remove();
		theQs.remove();
		theQs.displayList();
	}
}
