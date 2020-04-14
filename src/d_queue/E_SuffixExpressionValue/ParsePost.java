package d_queue.E_SuffixExpressionValue;

public class ParsePost {// infix to postfix conversion ��׺ת��׺ת��
	private StackX theStackX;
	private String input;

	public ParsePost(String in) {
		input = in;
		theStackX = new StackX(input.length());
	}

	public int doTrans() {// do translation to postfix ת���׺
		int num1, num2, interAns;
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			theStackX.displaysStack("For:" + ch);
			if (ch >= '0' && ch <= '9')
				theStackX.push((int) (ch - '0'));
			else {
				num2 = theStackX.pop();
				num1 = theStackX.pop();
				switch (ch) {
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				case '/':
					interAns = num1 / num2;
					break;
				default:
					interAns = 0;
				}
				theStackX.push(interAns);			}
		}
		interAns=theStackX.pop();
		return interAns;
	}
}
