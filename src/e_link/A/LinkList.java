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
		newLink.next=first;//�µ����ӵ����һ������һ���µ����ӵ�
		first=newLink;//�µ����ӵ�ΪnewLink		
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
