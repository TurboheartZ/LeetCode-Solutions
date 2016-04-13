import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        for(int i = 1; i<s.length(); i++){
            if(s.substring(i-1,i+1).equals("++")){
                result.add(s.substring(0,i-1)+"--"+s.substring(i+1,s.length()));
            }
        }
        return result;
    }
}
