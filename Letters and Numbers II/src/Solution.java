//Integer and Characters do not need to be successive
import java.util.*;
public class Solution {
	public static void main(String[] args){
		String i = "aaaaaaaaa11bdnc8371641111111";
		char[] input = i.toCharArray();
		System.out.println(longSub1(input));
		System.out.println(longSub2(input));
	}
	//****This algorithm uses Stack structure to solve this problem
	public static String longSub1(char[] s){
		if(s.length==0){
			return "";
		}
		else{
			Stack<Character> data = new Stack<Character>();
			Stack<String> container = new Stack<String>();
			String candidate = "";
			for(int i = 0; i<s.length; i++){
				if(data.isEmpty()==true){
					data.push(s[i]);
				}
				else{
					if(isChar(s[i])!=isChar(data.peek())){
						candidate = data.pop()+candidate+s[i];
						if(data.isEmpty()==true){
							if(container.isEmpty()==false){
								container.push(container.pop()+candidate);
							}
							else{
								container.push(candidate);
							}
							candidate = "";
						}
					}
					else{
						if(candidate.length()>0){
							container.push(candidate);
							candidate = "";
						}
						data.push(s[i]);
					}
				}
			}
			container.push(candidate);//Do not forget last one!
			String max = "";
			for(String x : container){
				max = x.length()>max.length()?x:max;
			}
			return max;
		}
	}
	//****This algorithm uses Difference to solve the problem
	//****If at index a and index b, the difference between characters and integers are equal
	//****We know that the sub-array between index a and index b is a matching array
	public static String longSub2(char[] s){
		if(s.length==0){
			return "";
		}
		else{
			HashMap<Integer, Integer> record  = new HashMap<Integer, Integer>();
			int charNum =  0;
			int digitNum = 0;
			record.put(0, -1);
			String max = "";
			for(int i = 0; i<s.length; i++){
				if(isChar(s[i])==true){
					charNum++;
				}
				else{
					digitNum++;
				}
				int diff = digitNum-charNum;
				if(record.containsKey(diff)==true){
					max = i-record.get(diff)>max.length()?String.copyValueOf(s, record.get(diff)+1, i-record.get(diff)):max;
				}
			}
			return max;
		}
	}
	private static boolean isChar(char input){
		return ((input-'a'>=0&&input-'a'<26)||(input-'A'>=0&&input-'A'<26))?true:false;
	}
}
