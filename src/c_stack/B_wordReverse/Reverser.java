package c_stack.B_wordReverse;
/**
 * ·´×ª
 * @author Administrator
 *
 */
public class Reverser {
	private String input;
	private String output;
	public Reverser(String in) {
	input=in;
	}
	public String doRev(){
		int stackSize=input.length();
		WordReverse wordReverse=new WordReverse(stackSize);
		
		for(int i=0;i<stackSize;i++){
			char c=input.charAt(i);
			wordReverse.push(c);
		}
		output="";
		while(!wordReverse.isEmpty()){
			output+=wordReverse.pop();
		}
		return output;
	}

}
