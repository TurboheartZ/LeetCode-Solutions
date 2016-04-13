
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //The key element to solve this problem is "0"
    //If there are no "0" inside the array, then return true
    //If there are "0", we need to make sure the previous element>=2 or pre-previous >=3
    //Therefore, we can iterate from right to left
    public static boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        else{
            int flag = 0;
            for(int i = nums.length-2; i>=0; i--){
                //Start from nums[nums.length-2] because if the last element is "0", it wont effect.
                if(flag==0){
                    if(nums[i]==0){
                        flag = 1;
                    }
                }
                else{
                    if(nums[i]>flag){
                        flag = 0;
                    }
                    else{
                        flag++;
                    }
                }
            }
            return flag==0;
        } 
    }
}
