package e_link.C_FirstLastList;

/**
 * 双端链表：增加对最后一个链点的引用
 * 	注意事项	
 * 		插入头尾时考虑链表是否为空，若是则为first或者last赋值
 * 		删除时注意链表下一个元素是否为空，若是last为null
 * 	局限性：
 * 		无法删除最后一个链接点，因为没有引用指向倒数第二个链接点。倘若最后一个连接点被删除，倒数第二个的next应该为null。
 * @author Administrator
 *
 *
 */
public class LinkListApp {
	public static void main(String[] args) {
		FirstLastList theList = new FirstLastList();
		//表头插入数据颠倒顺序
		theList.insertFirst(10);
		theList.insertFirst(20);
		theList.insertFirst(30);
		theList.insertFirst(40);

		//表尾插入数据不会颠倒
		theList.insertLast(50);
		theList.insertLast(60);
		theList.insertLast(70);

		theList.displaysList();
		System.out.println("------------");
		theList.deleteFirst();
		theList.deleteFirst();
		theList.deleteFirst();

		theList.displaysList();

	}

}
