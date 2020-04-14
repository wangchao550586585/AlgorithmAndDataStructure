package e_link.H_doublyLinked;

public class Link {
	public long data;
	public Link next;
	public Link previous;

	public Link(long dd) {
		data = dd;
	}

	public void displayLink() {
		System.out.print(data + " ");
	}

}
