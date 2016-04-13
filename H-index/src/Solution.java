import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {3,0,6,1,5};
		System.out.println(hIndex(input));
	}
    public static int hIndex(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        for (int i=citations.length-1;i>=0;i--){
        	if(citations[i]>=(citations.length-i)){
        		result = citations.length-i;
        	}
        	else{
        		break;
        	}
        }
        return result;
    }
}
