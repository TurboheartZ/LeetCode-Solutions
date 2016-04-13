import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "cbacdcbc";
		System.out.println(input+"aaa");
		System.out.println(removeDuplicateLetters(input));

	}
    public static String removeDuplicateLetters(String s) {
        int length = s.length();
        if(length<=1){
            return s;
        }
        else{
            HashMap<Character, Integer> record = new HashMap<Character, Integer>();
            for(int i = 0; i<length; i++){
                //Record the appearance times of each character
                char c = s.charAt(i);
                if(record.containsKey(c)==false){
                    record.put(c,1);
                }
                else{
                    record.put(c,record.get(c)+1);
                }
            }
            Stack<Character> result = new Stack<Character>();
            for(int i = 0; i<length; i++){
                char c = s.charAt(i);
                if(result.isEmpty()==true){
                    result.push(c);
                }
                else if(result.contains(c)==false){
                    char b = result.peek();
                    if(b<c){
                        result.push(c);
                    }
                    else if(b>c){
                        char d = result.peek();
                        while(d>=c&&record.get(d)>=1){//Pop out the previous chars in the stack which are lager than c and will appear later
                            result.pop();
                            if(result.isEmpty()==true) break;
                            else d = result.peek();
                        }
                        result.push(c);
                    }
                }
                record.put(c,record.get(c)-1);//No matter push into stack or not, the appearance of the char reduce by 1
            }
            StringBuffer data = new StringBuffer();
            for(char c:result){
                data.append(c);
            }
            return data.toString();
        }
        
    }
}
