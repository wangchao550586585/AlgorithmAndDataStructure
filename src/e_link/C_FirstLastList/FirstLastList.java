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
	 * 第一个插入数据，考虑链表空，last要赋值
	 */
	public void insertFirst(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			last = newLink;
			newLink.next = first;
		first = newLink;
	}

	/*
	 * 最后一个插入数据，考虑链表空，first要赋值
	 * 
	 */
	//不设置else的话，last.next = newLink;有问题
	public void insertLast(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
	}

	/*
	 * 删除链表第一个对象，并返回第一个值,考虑first.next==null
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
