package d_queue.D_SuffixExpression;

public class IntoPost {// infix to postfix conversion ��׺ת��׺ת��
	private StackX theStackX;
	private String input;
	private String output = "";

	public IntoPost(String in) {
		input = in;
		theStackX = new StackX(input.length());
	}

	public String doTrans() {// do translation to postfix ת���׺
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			theStackX.displaysStack("For:"+ch);
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch,1);
				break;
			case '*':
			case '/':
				gotOper(ch,2);
				break;
			case '(':
				theStackX.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
					output=output+ch;
					break;
			}
		}
		//��ջ�е���ʣ�µĲ�����
		while(!theStackX.isEmpty()){
			theStackX.displaysStack("While ");
			output=output+theStackX.pop();
		}
		theStackX.displaysStack("End ");
		return output;
	}

	private void gotOper(char opThis, int prec1) {
		while (!theStackX.isEmpty()) {
			char opTop = theStackX.pop();//��ΪҪ��ǰ���������Ƚ����ȼ�������Ҫ�ó���
			if (opTop == '(') {
				theStackX.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-') {
					prec2 = 1;
				} else {
					prec2 = 2;
				}
				if (prec2 < prec1) {
					theStackX.push(opTop);
					break;
				} else {
					output = output + opTop;
				}

			}
		}
		theStackX.push(opThis);
	}

	private void gotParen(char ch) {
		while(!theStackX.isEmpty()){
			char chx=theStackX.pop();
			if(chx=='('){
				break;
			}else{
				output=output+chx;
			}
		}
	}

}
