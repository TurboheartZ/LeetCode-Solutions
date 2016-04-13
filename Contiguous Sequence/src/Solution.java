
public class Solution {
	public static void main(String[] args){
		int[] input = {2,-8,3,-2,10,-12,100};
		System.out.println(sequence(input));
	}
	public static int sequence(int[] nums){
		if(nums.length==0){
			return Integer.MIN_VALUE;
		}
		else{
			int sum = nums[0];
			int can = 0;
			for(int i = 0; i<nums.length;i++ ){
				if(nums[i]<0){
					//Update sum value
					sum = can>sum?can:sum;
					if(can+nums[i]<0){
						can = 0;
					}
					else{
						can += nums[i];
					}
				}
				else{
					can += nums[i];
				}
			}
			sum = can>sum?can:sum;
			return sum;
		}
	}
}
