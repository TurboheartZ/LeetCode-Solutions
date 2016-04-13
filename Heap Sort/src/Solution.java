
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {49,38,65,97,76,13,27,49};
		int[] out = heapSort(input);
		System.out.println("Done");
	}
	public static int[] heapSort(int[] nums){
		int[] result = new int[nums.length];
		int sw;
		nums = heapBuild(nums, nums.length);
		for(int i = nums.length-1; i>=0; i--){
			result[nums.length-1-i] = nums[0];
			sw = nums[0];
			nums[0] = nums[i];
			nums[i] = sw;
			nums = heapAdjust(nums, 0, i);
		}
		return result;
	}
	private static int[] heapBuild(int[] nums, int length){
		for(int i = (length-1)/2; i>=0; i--){
			nums = heapAdjust(nums,i,length);
		}
		return nums;
	}
	private static int[] heapAdjust(int[] nums, int index, int length){
		int childIndex = index*2+1;
		int temp = nums[index];
		while(childIndex<length){
			if(childIndex+1<length){
				childIndex = nums[childIndex]<nums[childIndex+1]?childIndex:childIndex+1;
			}//Find the smaller child
			if(nums[childIndex]<nums[index]){
				nums[index] = nums[childIndex];
				nums[childIndex] = temp;
				index = childIndex;
				childIndex = childIndex*2+1;
			}
			else{
				break;
			}
		}
		return nums;
	}
}
