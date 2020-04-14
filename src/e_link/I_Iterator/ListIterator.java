package e_link.I_Iterator;

public class ListIterator {
	private Link current;
	private Link previous;
	private LinkList ourList;

	public ListIterator(LinkList ourList) {
		this.ourList = ourList;
		reset();
	}

	/*
	 * ���������ñ�ͷ
	 */
	public void reset() {
		current = ourList.getFirst();
		previous = null;

	}

	/*
	 * ����������ĩβ������null
	 */
	public boolean atEnd() {
		return current.next == null;
	}

	/*
	 * �������ƶ�����һ�����ӵ�
	 */
	public void nextLink() {
		previous = current;
		current = current.next;
	}

	/*
	 * ��ȡ��ǰ
	 */
	public Link getCurrent() {
		return current;
	}

	/*
	 * �������������һ�������ӵ�
	 */
	public void insertAfter(long dd) {
		Link newLink = new Link(dd);
		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;// ������ǰ���ӵĶ������ӵ�
		} else {
			newLink.next = current.next;
			current.next = newLink;
			nextLink();// ������ǰ���ӵĶ������ӵ�
		}

	}

	/*
	 * ������ǰ�����һ�������ӵ�
	 * ִ�к���currentָ���²�������ӵ�
	 */
	public void insertBefore(long dd) {
		Link newLink = new Link(dd);
		if (previous == null) {
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);// ��currentָ���²�������ӵ�
			reset();
		} else {
			newLink.next = previous.next;
			previous.next = newLink;
			current = newLink;// ��currentָ���²�������ӵ�
		}

	}

	/*
	 * ɾ����ǰ���ӵ�
	 * ִ�к���currentָ���²�������ӵ�
	 */
	public long deleteCurrent() {
		long value = current.dData;
		if (previous == null) {
			ourList.setFirst(current.next);
			reset();
		}
		else{
			previous.next=current.next;
			if(atEnd()){//���current��һ��Ϊnull
				reset();//current���ڵ�һ������
			}else{
				current=current.next;//��currentָ���²�������ӵ�
			}
		}
		return value;
	}

}
