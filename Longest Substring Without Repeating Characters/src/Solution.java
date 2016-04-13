import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abca";
		System.out.println(lengthOfLongestSubstring(input));
	}
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder data = new StringBuilder();
        HashSet<Character> container = new HashSet<Character>();
        for (int i=0;i<s.length();i++){
        	container.clear();
            StringBuilder data2 = new StringBuilder();        	
        	container.add(s.charAt(i));
        	data2.append(s.charAt(i));
        	for(int j=1;j<s.length()-i;j++){
        		if(container.add(s.charAt(i+j))==false){
        			break;
        		}
        		else{
        			data2.append(s.charAt(i+j));
        		}
        	}
        	if(data2.length()>data.length()){
        		data = data2;
        	}
        }
        return data.length();
    }
}
