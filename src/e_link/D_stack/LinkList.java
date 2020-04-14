package e_link.D_stack;

public class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(long dd) {
		Link link = new Link(dd);
		link.next = first;
		first = link;
	}

	public long deleteFirst() {
		Link current = first;
		first = first.next;
		return current.data;
	}
	public void displaysList(){
		Link current=first;
		while(current!=null){
		current.displayLink();
		current=current.next;
		}
	}

}
