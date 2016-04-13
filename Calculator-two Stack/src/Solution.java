import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "1+2+3-5+4";
		System.out.println(calculator(input));
	}
	private static int calculator(String input){
		int result = 0;
		Stack<Character> op = new Stack<Character>();
		int len = input.length();
		char prevOp = ' ';
		for(int i = 0; i<len; i++){
			if(input.charAt(i)-'0'>=0||input.charAt(i)-'0'<=9){
				//It is a number
				op.add(input.charAt(i));
			}
			else{
				if(op.isEmpty()==true){
					op.add(input.charAt(i));
				}
				else{
					//Only the operator with higher(not equal) priority need to be popped out
					if(input.charAt(i)=='+'||input.charAt(i)=='-'){
						int a = 0;
						int b = 0;
						if(op.isEmpty()==false) a = op.pop()-'0';
						if(op.isEmpty()==false) op.pop();
						if(op.isEmpty()==false) b = op.pop()-'0';
						int c = prevOp=='*'?b*a:b/a;
						op.push((char)(c+'0'));
						op.push(input.charAt(i));
						prevOp = input.charAt(i);
					}
					else{
						op.push(input.charAt(i));
						prevOp = input.charAt(i);
					}
				}
			}
		}
		int length = op.size();
		char 
		return result;
	}
}
