package e_link.G_listInsertionSort;

/**
 * ���������������������
 * 
 * @author Administrator
 *
 */
public class ListInsertionSortApp {
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArr = new Link[size];
		//����Link���鲢����math��10��ֵ
		for (int j = 0; j < size; j++) {
			int n = (int) (Math.random() * 99);
			Link newLink = new Link(n);
			linkArr[j] = newLink;
		}
		//���û�����ֵ
		for (int i = 0; i < size; i++) {
			System.out.print(linkArr[i].data + " ");
		}
		//������������
		SortedList s=new SortedList(linkArr);
		//����������linkArr��
		for (int i = 0; i < size; i++) {
			linkArr[i] =s.remove();
		}
		System.out.println("------");
		//���
		for (int i = 0; i < size; i++) {
			System.out.print(linkArr[i].data + " ");
		}
		
	}
}
