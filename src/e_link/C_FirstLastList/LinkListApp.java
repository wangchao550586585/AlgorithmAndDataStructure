package e_link.C_FirstLastList;

/**
 * ˫���������Ӷ����һ�����������
 * 	ע������	
 * 		����ͷβʱ���������Ƿ�Ϊ�գ�������Ϊfirst����last��ֵ
 * 		ɾ��ʱע��������һ��Ԫ���Ƿ�Ϊ�գ�����lastΪnull
 * 	�����ԣ�
 * 		�޷�ɾ�����һ�����ӵ㣬��Ϊû������ָ�����ڶ������ӵ㡣�������һ�����ӵ㱻ɾ���������ڶ�����nextӦ��Ϊnull��
 * @author Administrator
 *
 *
 */
public class LinkListApp {
	public static void main(String[] args) {
		FirstLastList theList = new FirstLastList();
		//��ͷ�������ݵߵ�˳��
		theList.insertFirst(10);
		theList.insertFirst(20);
		theList.insertFirst(30);
		theList.insertFirst(40);

		//��β�������ݲ���ߵ�
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
