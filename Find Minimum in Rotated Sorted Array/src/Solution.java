
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Use binary search to solve this problem
    public static int findMin(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        else{
            int first = 0, last = nums.length-1, mid=(last+first)/2;
            if(nums[last]>nums[first]){//Check if rotated
                return nums[0];
            }
            else{
                while(last-first>1){
                    mid = (last+first)/2;
                    if(nums[mid]>nums[first]){
                        first =  mid;
                    }
                    else if(nums[mid]<nums[last]){
                        last = mid;
                    }
                }
                return nums[last];
            }
        }
    }  
}
