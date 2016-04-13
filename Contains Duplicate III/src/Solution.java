import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,3,6,2};
		System.out.println(containsNearbyAlmostDuplicate(input, 1, 2));
	}
    //Notice Overflow
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Integer> mp = new HashMap<Long, Integer>();
        if(t<=k/2){
            for(int i = 0; i<nums.length; i++){
                for(long j = (long)nums[i]-(long)t; j<=(long)nums[i]+(long)t; j++){
                    if(mp.containsKey(j)){
                        if(i-mp.get(j)<=k){
                            return true;
                        }
                    }
                }
                mp.put((long)nums[i],i);
            }
            return false;            
        }
        else{
            for(int i = 0; i<nums.length; i++){
                int begin = Math.max(0,i-k);
                for(int j = begin; j<i; j++){
                    long diff = (long)nums[i]-(long)nums[j];
                    if(Math.abs(diff)<=t){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
