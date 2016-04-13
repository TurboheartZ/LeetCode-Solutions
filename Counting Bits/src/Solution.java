
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //if i is even, the number of 1s must equals to that of i/2, since it is a left shift operation
    //if i is odd, the number of 1s must be 1 bit more than to that of i-1. Since i-1 is even, the last digit is 0
    public int[] countBits(int num) {
        int[] nums = new int[num+1];
        for(int i = 1; i<=num; i++){
            if(i==1){
                nums[i] = 1;
            }
            else{
                if(nums[i]==0){
                    nums[i] = nums[i-1]+1;
                }
            }
            if(i*2<=num)
            nums[i*2] = nums[i];
        }
        return nums;
    }
}
