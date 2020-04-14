package c_stack.C_Infix;

public class InToPost {
	StackX theStackX;
	String input;
	String output = "";

	public InToPost(String in) {
		input = in;
		int stackSize = in.length();
		theStackX = new StackX(stackSize);
	}

	public String doTrans() {
		for (int i = 0; i < input.length(); i++) {
			char choice = input.charAt(i);
			switch (choice) {
			case '+':
			case '-':
				getOper(choice, 1);
				break;
			case '*':
			case '/':
				getOper(choice, 2);
				break;
			case '(':
				theStackX.push(choice);
				break;
			case ')':
				gotPraen(choice);
				break;
			default:// �����ǲ��������ۼ�
				output += choice;
				break;
			}

		}
		while (!theStackX.isEmpty()) {
			output += theStackX.pop();
		}
		return output;
	}

	private void gotPraen(char ch) {
		// �����������������(ʱ����ѭ��
		while (!theStackX.isEmpty()) {
			char opTop = theStackX.pop();
			if (opTop == '(')
				break;
			else {
				output += opTop;
			}
		}

	}

	private void getOper(char opThis, int prec1) {
		// ��ֹ�����Ľ����Ĳ�ֹһ����shile
		// ������������������ջ��������ź���
		while (!theStackX.isEmpty()) {
			char opTop = theStackX.pop();
			// ����ջ����(ʱ�����룬������ѭ��
			if (opTop == '(') {
				theStackX.push(opTop);
				break;
			} else {// �ж���������ȼ���С�����ڷŻ�ջ�У������򵯳���������һ��ѭ���ж�
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) {
					theStackX.push(opTop);
					break;
				}
				output += opTop;
			}
		}
		theStackX.push(opThis);
	}

}
