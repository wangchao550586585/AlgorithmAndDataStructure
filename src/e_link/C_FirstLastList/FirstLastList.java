package e_link.C_FirstLastList;

public class FirstLastList {
	private Link first;
	private Link last;

	public FirstLastList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	/*
	 * ��һ���������ݣ���������գ�lastҪ��ֵ
	 */
	public void insertFirst(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			last = newLink;
			newLink.next = first;
		first = newLink;
	}

	/*
	 * ���һ���������ݣ���������գ�firstҪ��ֵ
	 * 
	 */
	//������else�Ļ���last.next = newLink;������
	public void insertLast(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
	}

	/*
	 * ɾ�������һ�����󣬲����ص�һ��ֵ,����first.next==null
	 */
	public long deleteFirst() {
		long temp = first.dData;
		if (first.next == null)
			last = null;
		first = first.next;
		return temp;
	}

	public void displaysList() {
		Link current = first;
		while (current != null) {
			current.displayink();
			current = current.next;
		}
	}
}
