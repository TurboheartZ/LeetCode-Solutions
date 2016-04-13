import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //We should use memorization method to save time
    public static boolean wordBreak(String s, Set<String> wordDict) {
        int length = s.length();
        boolean[] possible = new boolean[length+1];
        //possible[i] means the substring from 0 to i
        possible[1] = wordDict.contains(s.substring(0,1));
        for(int i = 1; i<=length; i++){
            for(int j = i-1; j>=0; j--){
                if(j>0&&possible[j]&&wordDict.contains(s.substring(j,i))){
                    possible[i] = true;
                    break;
                }
                else if(j==0&&wordDict.contains(s.substring(0,i))){
                    possible[i] = true;
                    break;
                }
            }
        }
        return possible[length];
    }
}
