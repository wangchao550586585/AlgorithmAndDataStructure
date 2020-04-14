package e_link.E_queue;

public class Link {
	public long data;
	public Link next;

	public Link(long d) {
		data = d;
	}

	public void displayLink() {
		System.out.println(data);
	}
}
