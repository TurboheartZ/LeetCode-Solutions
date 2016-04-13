import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> data = new ArrayList<Integer>();
		data.add(1);
		HashMap<List<Integer>,Integer> filter = new HashMap<List<Integer>, Integer>();
		filter.put(data, 2);
		int[] input = {0,1,1};//{-7,-1,-13,2,13,2,12,3,-11,3,7,-15,2,-9,-13,-13,11,-10,5,-13,2,-12,0,-8,8,-1,4,10,-13,-5,-6,-4,9,-12,5,8,5,3,-4,9,13,10,10,-8,-14,4,-6,5,10,-15,-1,-3,10,-15,-4,3,-1,-15,-10,-6,-13,-9,5,11,-6,-13,-4,14,-3,8,1,-4,-5,-12,3,-11,7,13,9,2,13,-7,6,0,-15,-13,-11,-8,9,-14,1,11,-7,13,0,-6,-15,11,-6,-2,4,2,9,-15,5,-11,-11,-11,-13,5,7,7,5,-10,-7,6,-7,-11,13,9,-10,-9};
		System.out.println(threeSum(input));
	}
    //Once we determine the first number, we can use the Two-Pointer Method to find the rest two numbers
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return result;
        }
        else{
            Arrays.sort(nums);
            for(int i = 0; i<nums.length-2; i++){
                if(nums[i]>0){
                    break;//The first number must <= 0;
                }
                else if(i>0&&nums[i]==nums[i-1]){
                	continue;
                }
                else{
                    int rem = -nums[i];
                    int lo = i+1;
                    int hi = nums.length-1;
                    while(lo<hi){
                        if(nums[lo]+nums[hi]==rem){
                            result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                            //Since the first number is settled, we need to make sure the rest numbers are not duplicates
                            while(lo<hi&&nums[lo+1]==nums[lo]) lo++;
                            lo++;
                            while(lo<hi&&nums[hi-1]==nums[hi]) hi--;
                            hi--;
                        }
                        else if(nums[lo]+nums[hi]<rem){
                            while(lo<hi&&nums[lo+1]==nums[lo]) lo++;
                            lo++;
                        }
                        else if(nums[lo]+nums[hi]>rem){
                            while(lo<hi&&nums[hi-1]==nums[hi]) hi--;
                            hi--;
                        }
                    }
                }
            }
            return result;
        }
    }
}
