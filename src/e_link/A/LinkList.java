package e_link.A;

public class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public boolean isEmpty() {
		return first==null;
	}
	public void insert(int id,double dd){
		Link newLink=new Link(id, dd);
		newLink.next=first;//新的链接点的下一个是上一个新的链接点
		first=newLink;//新的链接点为newLink		
	}
	public Link deleteFirst(){
		Link temp=first;
		first=first.next;
		return temp;
	}
	public void displayList(){
		System.out.println("List (first-->last):");
		Link current=first;
		while(current!=null){
			current.displaysLink();
			current=current.next;
		}
		System.out.println("");
	}
	
}
