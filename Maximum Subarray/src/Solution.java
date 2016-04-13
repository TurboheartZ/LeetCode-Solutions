
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Also we can use DP to solve it
    public static int maxSubArray(int[] nums) {
        int[] container = new int[nums.length];
        container[0] = nums[0];
        int max=container[0];
        for(int i=1;i<nums.length;i++){
            container[i] = Math.max(container[i-1],0) + nums[i];
            if(container[i]>max){
                max=container[i];
            }
        }
        return max;
    }
}
