import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7,8,8,7,6,5,4,3,1};
		System.out.println(singleNumber(num));
	}
	
	//This is quite an Ordinary and Time-consuming solution
//	public static int singleNumber (int[] nums){
//		int result = nums[0];
//		int flag = 0;
//		Arrays.sort(nums);
//		for (int i = 0;i<nums.length-1;i+=2){
//			if(nums[i]!= nums[i+1]){
//				result = nums[i];
//				flag = 1;
//				break;
//			}
//			else{
//				continue;
//			}
//		}
//		return flag==1?result:nums[nums.length-1];
//	}
	
	//Here we can use Bit-Manipulation to solve this problem
	public static int singleNumber(int[] nums){
		int result = 0;
		for (int i:nums){
			result ^= i;
		}
		return result;
	}

}
