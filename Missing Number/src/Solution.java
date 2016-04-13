
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int missingNumber(int[] nums) {
        //I think we can use sum=n*(n+1)/2 to solve this problem
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return (nums.length+1)*(nums.length)/2-sum;
    }
}
