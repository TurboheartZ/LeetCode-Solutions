import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3};
		System.out.println(subsets(input));
	}
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        result.add(item);
        Arrays.sort(nums);
        if(nums.length>0){
        	for(int i=0;i<nums.length;i++){
        		int sz = result.size();
        		for(int j=0;j<sz;j++){        	
        			List<Integer> newList = new ArrayList<Integer>(result.get(j));
        			newList.add(nums[i]);
        			result.add(newList);
        		}
        	}
        }
        return result;
    }
}
