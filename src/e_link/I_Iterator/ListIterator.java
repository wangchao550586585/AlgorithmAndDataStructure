package e_link.I_Iterator;

public class ListIterator {
	private Link current;
	private Link previous;
	private LinkList ourList;

	public ListIterator(LinkList ourList) {
		this.ourList = ourList;
		reset();
	}

	/*
	 * 迭代器设置表头
	 */
	public void reset() {
		current = ourList.getFirst();
		previous = null;

	}

	/*
	 * 迭代器到达末尾，返回null
	 */
	public boolean atEnd() {
		return current.next == null;
	}

	/*
	 * 迭代器移动到下一个链接点
	 */
	public void nextLink() {
		previous = current;
		current = current.next;
	}

	/*
	 * 获取当前
	 */
	public Link getCurrent() {
		return current;
	}

	/*
	 * 迭代器后面插入一个新链接点
	 */
	public void insertAfter(long dd) {
		Link newLink = new Link(dd);
		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;// 跳到当前增加的对象链接点
		} else {
			newLink.next = current.next;
			current.next = newLink;
			nextLink();// 跳到当前增加的对象链接点
		}

	}

	/*
	 * 迭代器前面插入一个新链接点
	 * 执行后，让current指向新插入的链接点
	 */
	public void insertBefore(long dd) {
		Link newLink = new Link(dd);
		if (previous == null) {
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);// 让current指向新插入的链接点
			reset();
		} else {
			newLink.next = previous.next;
			previous.next = newLink;
			current = newLink;// 让current指向新插入的链接点
		}

	}

	/*
	 * 删除当前链接点
	 * 执行后，让current指向新插入的链接点
	 */
	public long deleteCurrent() {
		long value = current.dData;
		if (previous == null) {
			ourList.setFirst(current.next);
			reset();
		}
		else{
			previous.next=current.next;
			if(atEnd()){//如果current下一个为null
				reset();//current等于第一个对象
			}else{
				current=current.next;//让current指向新插入的链接点
			}
		}
		return value;
	}

}
