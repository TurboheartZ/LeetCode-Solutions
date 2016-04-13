import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    public static int evalRPN(String[] tokens) {
        int length = tokens.length;
        Stack<Integer> result = new Stack<Integer>();
        for(int i = 0; i<length; i++){
            char c = tokens[i].charAt(tokens[i].length()-1);
            if(c-'0'>=0&&c-'0'<=9){
                result.push(Integer.valueOf(tokens[i]));
            }
            else{
                int a=0,b=0,s=0;
                if(result.isEmpty()==false) a = result.pop(); 
                else break;
                if(result.isEmpty()==false) b = result.pop();
                else break;
                switch(c){
                    case '+': s = b+a; break;
                    case '-': s = b-a; break;
                    case '*': s = b*a; break;
                    case '/': s = b/a; break;
                    default: break;
                }
                result.push(s);
            }
        }
        return result.pop();
    }
}
