
public class Solution {
	public static void main(String[] args){
		int[] input = {1,2,5,9,5,9,5,5,5,9,9,9,9,9,9,9,9,9,9,4,5,6,7};
		System.out.println(majority(input));
	}
	public static int majority(int[] nums){
		if(nums.length==0){
			return -1;
		}
		else{
			int candidate = nums[0];
			int weight =0;
			for(int i = 0; i<nums.length; i++){
				if(nums[i]!=candidate){
					if(weight>0){
						weight--;
					}
					else if(weight==0){
						candidate =  nums[i];
						weight = 1;
					}
				}
				else{
					weight++;
				}
			}
			int count = 0;
			for(int x : nums){
				if(x==candidate){
					count++;
				}
			}
			return count>nums.length/2?candidate:-1;
		}
	}
}
