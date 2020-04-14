package c_stack.D_postfix;

public class ParsePost {
	private StackX theStackX;
	private String input;

	public ParsePost(String s) {
		input = s;
	}

	public int doParse() {
		int result;
		theStackX = new StackX(20);
		/**
		 * �ж��Ƿ�������������ջ���ж��Ƿ��ǲ����������򵯳�2�������������㡣
		 */
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch >= '0' && ch <= '9') {
				theStackX.push((int) (ch - '0'));// ת����int
			} else {
				int num2 = theStackX.pop();
				int num1 = theStackX.pop();

				switch (ch) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					result = 0;
					break;
				}
				System.out.println(result);
				theStackX.push(result);
			}
		}
		return theStackX.pop();
	}
}
