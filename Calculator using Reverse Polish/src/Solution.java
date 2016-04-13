import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "5+((1+2)*4)-3";
		String polish = polishGenerator(input);
		System.out.println(polishGenerator(input));
		System.out.println(polishCalculator(polish));
	}
	private static String polishGenerator(String input){
		StringBuffer result = new StringBuffer();
		Stack<Character> op = new Stack<Character>();
		int len = input.length();
		for(int i = 0; i<len; i++){
			//The char is a number
			if(input.charAt(i)-'0'>=0&&input.charAt(i)-'0'<=9){
				result.append(input.charAt(i));
			}
			else{
				if(op.isEmpty()==false){
					if(input.charAt(i)=='+'||input.charAt(i)=='-'){
						while(op.isEmpty()==false&&op.peek()!='('){
							result.append(op.pop());						
						}
						op.push(input.charAt(i));//Only left those whose priority lower(equal is not included)
					}
					else if(input.charAt(i)=='*'||input.charAt(i)=='/'){
						while(op.isEmpty()==false&&(op.peek()=='*'||op.peek()=='/')){
							result.append(op.pop());
						}
						op.push(input.charAt(i));
					}
					else if(input.charAt(i)==')'){
						//char is ')'
						while(op.isEmpty()==false&&op.peek()!='('){
							result.append(op.pop());						
						}
						if(op.isEmpty()==false){
							op.pop();
						}
					}
					else if(input.charAt(i)=='('){
						op.push(input.charAt(i));
					}
				}
				else{
					op.push(input.charAt(i));
				}
			}
		}
		while(op.isEmpty()==false){
			result.append(op.pop());
		}
		return result.toString();
	}
	private static int polishCalculator(String input){
		int result = 0;
		int len = input.length();
		Stack<Integer> data = new Stack<Integer>();
		for(int i = 0; i<len; i++){
			if(input.charAt(i)-'0'>=0&&input.charAt(i)-'0'<=9){
				data.push(input.charAt(i)-'0');
			}
			else{
				int a = 0;
				int b = 0;
				if(data.isEmpty()==false){
					a = data.pop();
				}
				if(data.isEmpty()==false){
					b = data.pop();
				}
				switch(input.charAt(i)){
				case '+':   result = b+a;
							break;
				case '-':	result = b-a;
							break;
				case '*':	result = b*a;
							break;
				default: 	result = b/a;
							break;
				}
				data.push(result);
			}
		}
		result = data.isEmpty()==true?0:data.pop();
		return result;
	}
}
