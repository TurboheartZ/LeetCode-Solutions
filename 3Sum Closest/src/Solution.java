import  java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,4,8,16,32,64,128};
		System.out.println(threeSumClosest(input, 82));
	}
    //Still use the Two-Pointer Method to solve this problem
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length<3){
            return 0;
        }
        else{
            Arrays.sort(nums);
            int diff = target-nums[0]-nums[1]-nums[2];
            for(int i = 0; i<nums.length-2; i++){
                if(i>0&&nums[i-1]==nums[i]){
                    continue;
                }
                else{
                    int lo = i+1;
                    int hi = nums.length-1;
                    int rem;
                    while(lo<hi){
                        rem = target-nums[i]-nums[lo]-nums[hi];
                        if(rem==0){
                            diff = 0;
                            break;
                        }
                        else{
                            if(Math.abs(rem)<Math.abs(diff)){
                            	diff = rem;
                            }
                            if(rem>0){
                                while(lo<hi&&nums[lo+1]==nums[lo]) lo++;
                                lo++;
                            }
                            else{
                                while(lo<hi&&nums[hi-1]==nums[hi]) hi--;
                                hi--;
                            }       
                        }
                    }
                    if(diff==0){
                        break;
                    }
                }
            }
            return target-diff;
        }
    }
}
