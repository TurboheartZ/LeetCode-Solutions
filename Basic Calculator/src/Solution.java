import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(input));
	}
    //Reverse Polish Exp
    public static int calculate(String s) {
        if(s.length()==0){
            return 0;
        }
        else{
            String num = "";
            Stack<String> number = new Stack<String>();
            Stack<Character> op = new Stack<Character>();
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    num += s.charAt(i);
                }
                else{
                    if(num.length()!=0){
                        number.push(num);
                    }
                    num = "";
                    if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                        while(op.isEmpty()==false&&op.peek()!='('){
                            char opr = op.pop();
                            int n1 = Integer.valueOf(number.pop());
                            int n2 = Integer.valueOf(number.pop());
                            if(opr=='+'){
                                number.push(String.valueOf(n2+n1));
                            }
                            else{
                                number.push(String.valueOf(n2-n1));//Notice the order
                            }
                        }
                        op.push(s.charAt(i));
                    }
                    else if(s.charAt(i)=='('){
                        op.push(s.charAt(i));
                    }
                    else if(s.charAt(i)==')'){
                        while(op.isEmpty()==false){
                            char opr = op.pop();
                            if(opr=='('){
                                break;
                            }
                            int n1 = Integer.valueOf(number.pop());
                            int n2 = Integer.valueOf(number.pop());
                            if(opr=='+'){
                                number.push(String.valueOf(n2+n1));
                            }
                            else{
                                number.push(String.valueOf(n2-n1));//Notice the order
                            }
                        }                       
                    }
                }
            }
            if(num.length()!=0){
                number.push(num);
            }
            while(op.isEmpty()==false){
                char opr = op.pop();
                int n1 = Integer.valueOf(number.pop());
                int n2 = Integer.valueOf(number.pop());
                if(opr=='+'){
                    number.push(String.valueOf(n2+n1));
                }
                else{
                    number.push(String.valueOf(n2-n1));//Notice the order
                }                
            }
            return Integer.valueOf(number.pop());
        }
    }
}
