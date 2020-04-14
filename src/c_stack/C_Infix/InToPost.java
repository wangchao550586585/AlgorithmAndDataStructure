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
			default:// 必须是操作数，累加
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
		// 弹出所有数据项，当是(时结束循环
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
		// 防止弹出的结束的不止一个，shile
		// 不管怎样操作都会入栈，提出来放后面
		while (!theStackX.isEmpty()) {
			char opTop = theStackX.pop();
			// 当出栈的是(时，放入，并结束循环
			if (opTop == '(') {
				theStackX.push(opTop);
				break;
			} else {// 判断运算符优先级，小于则在放回栈中，大于则弹出。进行下一次循环判断
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
