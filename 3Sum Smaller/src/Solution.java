import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//****This solution use two pointers indicating the next smallest elements and the largest elements
	//****And shrink from those two elements
	//****Time complexity is O(N^2)
    public int threeSumSmallerOptimized(int[] nums, int target) {
        if(nums.length<3){
            return 0;
        }
        else{
            Arrays.sort(nums);
            int count = 0;
            int lo;
            int hi;
            for(int i = 0; i<nums.length-2; i++){
                lo = i+1;
                hi = nums.length-1;
                while(lo<hi){
                    if(nums[i]+nums[lo]+nums[hi]<target){
                        count += hi-lo;
                        lo++;
                    }
                    else{
                        hi--;
                    }
                }
            }
            return count;
        }
    }
	
	
	//****In the solution, I used a HashMap to save the time spent on searching for the element
	//****However, the time spent on building the HashMap is quite large, which is O(K) where K is the largest difference
	//****between two elements
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length<=2){
            return 0;
        }
        else{
            Arrays.sort(nums);
            HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
            int start = nums[0];
            int count = 1;
            record.put(nums[0],1);
            for(int i = 1; i<nums.length; i++){
                if(nums[i]!=start){
                    //****Although I tried to save the searching time by using hashmap, The process of building the map does cost time
                    for(int j = start+1; j<nums[i]; j++){
                        record.put(j,count);
                    }
                    start = nums[i];
                }
                record.put(start,++count);
            }
            int result = 0;
            for(int i = 0; i<nums.length-2; i++){
                for(int j = i+1; j<nums.length-1; j++){
                    int remainer = target-nums[i]-nums[j]-1;
                    if(remainer<nums[j]){
                        continue;
                    }
                    if(remainer>nums[nums.length-1]){
                        int numofsmaller = nums.length-j-1;
                        if(numofsmaller>0){
                            result += numofsmaller;
                        }                         
                    }                    
                    else{
                        int indexofsmaller = record.get(remainer);
                        int numofsmaller = indexofsmaller-j-1;
                        if(numofsmaller>0){
                            result += numofsmaller;
                        }                        
                    }
                }
            }
            return result;
        }
    }
}
