import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //O(N) time complexity
    //subArray--> k[j---i] = sum[0---i]-sum[0---j]
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        else{
            HashMap<Integer,Integer> record = new HashMap<Integer,Integer>();
            int sum = 0;
            int maxLen = 0;
            for(int i = 0; i<nums.length; i++){
                sum += nums[i];
                if(sum==k){
                    maxLen = i+1;
                }
                else if(record.containsKey(sum-k)){
                    maxLen = Math.max(maxLen,i-record.get(sum-k));
                }
                if(record.containsKey(sum)==false){
                    record.put(sum,i);
                }
            }
            return maxLen;
        }
    }
}
