
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int searchInsert(int[] nums, int target) {
        //Divided into 2 parts
        int result=0;
        int first=0;
        int last=nums.length;
        int flag=0;
        if(target==nums[(nums.length-1)/2]){
            return (nums.length-1)/2;
        }
        else if(target<nums[0]){
            return 0;
        }
        else if(target>nums[nums.length-1]){
            return nums.length;
        }
        else {
            if(target<nums[(nums.length-1)/2]){
                last=(nums.length-1)/2;
            }
            else if(target>nums[(nums.length-1)/2]){
                first=(nums.length-1)/2;
            }
            while(last-first>1){
                if(nums[(first+last)/2]==target){
                    result=(first+last)/2;
                    flag=1;
                    break;
                }
                else if(nums[(first+last)/2]>target){
                    last=(first+last)/2;
                }
                else{
                    first=(first+last)/2;
                }
            }
            if(flag==1){
                return result;
            }
            else{
                if(nums[first]==target){
                    return first;
                }
                else{
                    return last;
                }
            }
        }
    }
}
