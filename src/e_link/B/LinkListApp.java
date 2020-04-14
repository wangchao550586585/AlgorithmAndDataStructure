package e_link.B;
/**
 * 单链表:针对key查询，或者删除
 * @author Administrator
 *
 */
public class LinkListApp {
	public static void main(String[] args) {
		LinkList theList=new LinkList();
		theList.insertFirst(1, 10);
		theList.insertFirst(2, 20);
		theList.insertFirst(3, 30);
		theList.insertFirst(4, 40);
		theList.insertFirst(5, 50);
		theList.insertFirst(6, 60);
		theList.insertFirst(7, 70);
		
		theList.displaysList();
		theList.find(1).displaysLink();
		theList.delete(7).displaysLink();
		System.out.println();
		theList.displaysList();
	}

}
