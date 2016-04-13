
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,3,-2,4};
		System.out.println(maxProduct(input));
	}
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            int product = 1;
            int rowMax = nums[i];
            int neg=0;
            int j=i;
            for (; j<nums.length; j++) {
               if (nums[j] == 0) break;
               product = product*nums[j];
               if (nums[j]<0) neg++;
               if (neg%2==0) rowMax = product;//Only when 2 negative both included, product get upgraded
            }
            max = Math.max(rowMax, max);
            if (neg%2==0 && j==nums.length) return max; 
        }
        return max;
    }    
//Actually, we can use DP to solve this problem by setting two variables:maxPositive and maxNegative
}
