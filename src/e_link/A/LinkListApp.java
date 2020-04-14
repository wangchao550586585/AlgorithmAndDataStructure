package e_link.A;
/**
 * 单链表:增删
 * 对象引用对象
 * @author Administrator
 *
 */
public class LinkListApp {
	public static void main(String[] args) {
		LinkList theList=new LinkList();
		theList.insert(1, 10);
		theList.insert(2, 20);
		theList.insert(3, 30);
		theList.insert(4, 40);
		theList.insert(5, 50);
		theList.insert(6, 60);
		theList.insert(7, 70);
		theList.displayList();
		
		while(!theList.isEmpty()){
			Link aLink=theList.deleteFirst();
			System.out.print("Deleted ");
			aLink.displaysLink();
			System.out.println();
		}
		theList.displayList();
	}

}
