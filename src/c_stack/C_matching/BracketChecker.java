package c_stack.C_matching;

public class BracketChecker {
	private String input;

	public BracketChecker(String input) {
		this.input = input;
	}

	public void check() {
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);
		for (int j = 0; j < stackSize; j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				// �����Ϊ��
				if (!theStack.isEmpty()) {
					char chx = theStack.pop();
					if (ch == '}' && chx != '{' || ch == ']' && chx != '['
							|| ch == ')' && chx != '(') {
						System.out.println("Error" + ch + " at" + j);
					}
				} else {
					System.out.println("Error" + ch + " at" + j);
				}
				break;
			default:
				break;
			}
		}
		// ��ջ��ջ��Ϊ���򱨴�
		if (!theStack.isEmpty()) {
			System.out.println("Error:missing right delimiter");
		}
	}
}
