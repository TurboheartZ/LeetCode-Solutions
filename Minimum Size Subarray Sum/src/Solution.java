import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Firstly, let the elements add to the value of S, use 'right' to index
    //Then, shrink from the leftside towards rightside
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null){
            return 0;
        }
        else{
            int sum=0;
            int right=0;
            int left=0;
            int len=nums.length;
            int flag=0;
            while(right<nums.length){
                while(sum<s&&right<nums.length){
                    sum+=nums[right++];
                }
                while(sum>=s){
                    sum-=nums[left++];
                    flag=1;
                }
                if(len>(right-left+1)){
                    len=right-left+1;
                }
            }
            return flag==1?len:0;
        }
    }

}
