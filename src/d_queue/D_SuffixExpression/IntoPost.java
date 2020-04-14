package d_queue.D_SuffixExpression;

public class IntoPost {// infix to postfix conversion 中缀转后缀转换
	private StackX theStackX;
	private String input;
	private String output = "";

	public IntoPost(String in) {
		input = in;
		theStackX = new StackX(input.length());
	}

	public String doTrans() {// do translation to postfix 转变后缀
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
		//从栈中弹出剩下的操作符
		while(!theStackX.isEmpty()){
			theStackX.displaysStack("While ");
			output=output+theStackX.pop();
		}
		theStackX.displaysStack("End ");
		return output;
	}

	private void gotOper(char opThis, int prec1) {
		while (!theStackX.isEmpty()) {
			char opTop = theStackX.pop();//因为要和前面的数据项比较优先级，所以要拿出来
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
