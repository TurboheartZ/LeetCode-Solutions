import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input ={1, 3, 2, 2, 3, 1};
		wiggleSort(input);
		System.out.println("ok");
	}
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] data = new int[nums.length];
        int a = nums.length%2==1?nums.length/2:nums.length/2-1;
        for(int i = 0; i<=a; i++){
            data[i*2] = nums[a-i];//Put the smaller numbers into the new array with the reversed order, so did to the larger numbers
        }
        for(int i = a+1; i<nums.length; i++){
            data[(i-a-1)*2+1] = nums[nums.length-1-(i-a-1)];//So that we can avoid the adjacent equal numbers in the middle
        }
        for(int i = 0; i<nums.length; i++){
            nums[i] = data[i];
        } 
    }
}
