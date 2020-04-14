package e_link.D_stack;

/**
 * ¡¥±Ì µœ÷’ª
 * 
 * @author Administrator
 *
 */
public class LinkStackApp {
	public static void main(String[] args) {
		LinkStack linkStack = new LinkStack();
		linkStack.push(10);
		linkStack.push(20);
		linkStack.push(30);
		linkStack.push(40);

		linkStack.displayStack();

		linkStack.pop();
		linkStack.push(70);
		linkStack.push(40);
		System.out.println("-----");
		linkStack.displayStack();

		linkStack.pop();
		linkStack.pop();
		System.out.println("-----");
		linkStack.displayStack();
	}
}
