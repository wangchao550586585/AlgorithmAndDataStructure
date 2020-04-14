package e_link.B;

public class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}

	/*
	 * 根据指定key查询连接点
	 */
	public Link find(int key) {
		Link current = first;
		while (current.iDate != key) {
			if (current.next == null)
				return null;
			else
				current = current.next;
		}
		return current;

	}

	
	/*
	 * 根据key删除指定的连接点
	 */
	public Link delete(int key) {
		Link current = first;// 当前
		Link previous = first;// 前一个
		while (current.iDate != key) {
			if (current.next == null)
				return null;
			else {
				previous = current;
				current = current.next;
			}
		}
		if (current == first)
			first = current.next;
		else
			previous.next = current.next;
		return current;

	}
public void displaysList(){
	Link current=first;
	while(current.next!=null){
		current.displaysLink();
		current=current.next;
		System.out.println();
	}
}
}
