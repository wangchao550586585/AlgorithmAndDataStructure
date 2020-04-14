package e_link.B;

public class Link {
	public int iDate;
	public double dDate;
	public Link next;
	public Link(int id,double dd){
		iDate=id;
		dDate=dd;
	}
	public void displaysLink(){
		System.out.print("{"+iDate+","+dDate+"}");
	}

}
