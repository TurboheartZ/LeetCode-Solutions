import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> result = findRepeatedDnaSequences(input);
		System.out.println(result);
		
	}
    public  static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> data = new HashMap<String,Integer>();
        HashSet<String> filter = new HashSet<String>();
        int len = s.length();
        for (int i = 0;i<=len-10;i++){
        	String DNA = s.substring(i, i+10);
        	if(data.put(DNA,i)!=null){
        		filter.add(DNA);
        		continue;
        	}
        }
        List<String> result = new LinkedList<String>(filter);
        return result;
    }
    //We can also use 2-bit binary code to denote A,C,T,G and use bit manipulation to solve this problem.
}
