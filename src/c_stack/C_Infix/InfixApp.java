package c_stack.C_Infix;

/**
 * @author Administrator ��׺���ʽ���ɺ�׺
 */
public class InfixApp {
	public static void main(String[] args) {
		String input = " 3 + 4 - 6 / 2 * (6 + 3 * (4 - 1))";
		
		InToPost theIt = new InToPost(input);
		String result = theIt.doTrans();
		System.out.println(result);
	}
}
