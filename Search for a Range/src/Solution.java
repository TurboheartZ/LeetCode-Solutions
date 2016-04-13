
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        int[] result={-1,-1};
        if(target<nums[0]||target>nums[len-1]){
            return result;
        }
        else{
            int first=0;
            int last=len-1;
            double left=target-0.1;
            int mid;
            while(last-first>1){
                mid=(first+last)/2;
                if(left>nums[mid]){
                    first=mid;
                }
                else{
                    last=mid;
                }
            }
            if(nums[0]==target){
                last=0;
            }
            result[0]=nums[last]==target?last:-1;
            first=0;
            last=len-1;
            double right=target+0.1;
            while(last-first>1){
                mid=(first+last)/2;
                if(right>nums[mid]){
                    first=mid;
                }
                else{
                    last=mid;
                }
            }
            if(nums[nums.length-1]==target){
                first=nums.length-1;
            }
            result[1]=nums[first]==target?first:-1;
        }
        return result;
    }
}
