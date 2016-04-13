import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6,7,8,9};
		List<Integer> data = new ArrayList<Integer>();
		String ab=Arrays.toString(peakValley(input));
		System.out.println(ab);
	}
	//If the left is larger than this node, we check this node and its right adjacent node, swap if right<mid
	//If the left is smaller than this node, swap if right right>mid
	//O(n) time complexity
	public static int[] peakValley(int[] nums){
		if(nums.length<=1) return nums;
		else{
			for(int i = 1; i<nums.length-1; i+=2){
				if((nums[i-1]>nums[i])&&(nums[i]>nums[i+1])) swap(nums,i,i+1);
				else if((nums[i-1]<nums[i])&&(nums[i]<nums[i+1])) swap(nums,i,i+1);
			}
			return nums;
		}
	}
	private static void swap(int[] nums, int index1, int index2){
		int temp = nums[index2];
		nums[index2] = nums[index1];
		nums[index1] = temp;
	}
}
