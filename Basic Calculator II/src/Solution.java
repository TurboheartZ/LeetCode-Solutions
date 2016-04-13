import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Reverse polish algorithm
    public int calculate(String s) {
        if(s.length()==0){
            return 0;
        }
        else{
            char[] exp = s.toCharArray();
            Stack<Integer> num = new Stack<Integer>();
            Stack<Character> op = new Stack<Character>();
            int sum = 0;
            boolean valid = false;
            for(int i = 0; i<exp.length; i++){
                if(exp[i]>='0'&&exp[i]<='9'){
                    valid = true;
                    sum = sum*10 + exp[i]-'0';
                }
                else if(exp[i]=='+'||exp[i]=='-'){
                    if(sum>=0&&valid){
                        num.push(sum);
                        sum = 0;
                        valid = false;
                        while(op.isEmpty()==false){
                            int b = num.pop();
                            int a = num.pop();
                            num.push(cal(a,b,op.pop()));
                        }
                    }
                    op.push(exp[i]);
                }
                else if(exp[i]=='*'||exp[i]=='/'){
                    if(sum>=0&&valid){//use the boolean valid to tell if sum is formed by previous numbers or just white spaces
                        num.push(sum);
                        sum = 0;
                        valid = false;
                        while(op.isEmpty()==false){
                            if(op.peek()=='+'||op.peek()=='-'){
                                break;
                            }
                            else{
                                int b = num.pop();
                                int a = num.pop();
                                num.push(cal(a,b,op.pop()));                               
                            }
                        }
                    }
                    op.push(exp[i]);
                }
                else{
                    if(sum>=0&&valid){
                        num.push(sum);
                        sum = 0;
                        valid = false;
                    }
                }
            }
            //Do not forget add the last possible number when the for loop exits
            if(sum>=0&&valid){
                num.push(sum);
            }
            while(op.isEmpty()==false){
                int b = num.pop();
                int a = num.pop();
                num.push(cal(a,b,op.pop()));
            }
            return num.isEmpty()?0:num.pop();
        }
    }
    
    private int cal(int a, int b, char op){
        if(op=='+') return a+b;
        else if(op=='-') return a-b;
        else if(op=='*') return a*b;
        else return a/b;
    }
}
