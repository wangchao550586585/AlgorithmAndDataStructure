package c_stack.D_postfix;

/**
 * 运算后缀表达式
 * @author Administrator
 *
 */
public class PostfixApp {
	public static void main(String[] args) {
		String input = "34+62/6341-*+*-";
		//3 + 4 - 6 / 2 * (6 + 3 * (4 - 1));
		ParsePost p = new ParsePost(input);
		int result = p.doParse();
		System.out.println(result);
	}
}
