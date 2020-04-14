package e_link.G_listInsertionSort;

/**
 * 利用有序链表给数组排序
 * 
 * @author Administrator
 *
 */
public class ListInsertionSortApp {
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArr = new Link[size];
		//创建Link数组并利用math赋10个值
		for (int j = 0; j < size; j++) {
			int n = (int) (Math.random() * 99);
			Link newLink = new Link(n);
			linkArr[j] = newLink;
		}
		//输出没排序的值
		for (int i = 0; i < size; i++) {
			System.out.print(linkArr[i].data + " ");
		}
		//创建对象并排序
		SortedList s=new SortedList(linkArr);
		//排序对象放入linkArr中
		for (int i = 0; i < size; i++) {
			linkArr[i] =s.remove();
		}
		System.out.println("------");
		//输出
		for (int i = 0; i < size; i++) {
			System.out.print(linkArr[i].data + " ");
		}
		
	}
}
