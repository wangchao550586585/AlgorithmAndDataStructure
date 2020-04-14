package e_link.D_stack;

public class LinkStack {
	private LinkList theList;

	public LinkStack() {
		theList = new LinkList();
	}

	public void push(long j) {
		theList.insertFirst(j);
	}

	public long pop() {
		return theList.deleteFirst();

	}
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	public void displayStack(){
		theList.displaysList();
	}
}
