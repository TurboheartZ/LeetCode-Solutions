import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2^1);
	}
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n<0){
            return result;
        }
        else{
            for(int i = 0; i<=Math.pow(2,n)-1; i++){
                int b = i/2;
                result.add(i^b);
            }
            return result;
        }
    }
}
