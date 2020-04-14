package e_link.J_FirstLastQue;

public class Link {
	public int iData;
	public Link next;
	public Link previous;

	public Link(int iData) {
		this.iData = iData;
	}

	public void displayLink() {
		System.out.print(iData + " ");
	}

}
