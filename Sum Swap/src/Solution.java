import java.util.*;
public class Solution {
	public static void main(String[] args){
		int[] input1 = {4,1,2,1,1,2};
		int[] input2 = {3,6,3,3};
		System.out.println(swap(input1,input2));
	}
	public static List<Integer> swap(int[] nums1, int[] nums2){
		List<Integer> result = new ArrayList<Integer>();
		if(nums1.length==0||nums2.length==0){
			return result;
		}
		else{
			//we actually can know the result sum, which is the even value of nums1's sum and nums2's sum
			//Thus we know the difference between the swapped values
			int sum1  = 0;
			for(int x : nums1){
				sum1 += x;
			}
			int sum2  = 0;
			HashSet<Integer> num2 = new HashSet<Integer>();
			for(int x : nums2){
				sum2 += x;
				num2.add(x);
			}
			int diff = sum2-(sum1+sum2)/2;
			for(int x : nums1){
				if(num2.contains(x+diff)){
					result.add(x);
					result.add(x+diff);
					break;
				}
			}
			return result;
		}
	}
}
