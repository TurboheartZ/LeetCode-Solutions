import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5,5,5,5};
		System.out.println(subsetsWithDup(input));
	}
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        HashSet<List<Integer>> filter = new HashSet<List<Integer>>();
        result.add(item);
        Arrays.sort(nums);
        int flag = 0;
        if(nums.length>0){
        	for(int i=0;i<nums.length;i++){
        		int sz = result.size();
        		for(int j=0;j<sz;j++){        	
        			List<Integer> newList = new ArrayList<Integer>(result.get(j));
        			newList.add(nums[i]);
        			if(filter.add(newList)==true){
        				result.add(newList);}        			
        			}
        	}
        }
        return result;        
    }
}
