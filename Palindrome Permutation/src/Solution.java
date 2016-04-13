import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean canPermutePalindrome(String s) {
        //Just check the number of characters
        //I used to try to use XOR to solve this problem but actually it is not a sufficient and necessary condition
        if(s.length()==0){
            return false;
        }
        else{
            HashMap<Character, Integer> filter = new HashMap<Character, Integer>();
            for(int i = 0;i<s.length(); i++){
                if(filter.containsKey(s.charAt(i))){
                    filter.remove(s.charAt(i));
                }
                else{
                    filter.put(s.charAt(i),1);
                }
            }
            return filter.size()<=1;
        }
    }
}
