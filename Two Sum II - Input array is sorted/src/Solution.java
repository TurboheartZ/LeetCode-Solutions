
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers.length<2){
            return result;
        }
        else{
            int lo = 0;
            int hi = numbers.length-1;
            while(lo<hi){
                if(numbers[lo]+numbers[hi]==target){
                    result[0] = lo+1;
                    result[1] = hi+1;
                    return result;
                }
                else if(numbers[lo]+numbers[hi]<target){
                    lo++;
                }
                else{
                    hi--;
                }
            }
            return result;
        }
    }
}
