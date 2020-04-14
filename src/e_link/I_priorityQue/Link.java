package e_link.I_priorityQue;

public class Link {
	public int iData;
	public Link next;

	public Link(int iData) {
		this.iData=iData;
	}

	public void display() {
		System.out.print(iData + " ");
	}
}
