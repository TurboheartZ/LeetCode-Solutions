import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {-489,-475,-469,-468,-467,-462,-456,-443,-439,-425,-425,-410,-401,-342,-341,-331,-323,-307,-299,-262,-254,-245,-244,-238,-229,-227,-225,-224,-221,-197,-173,-171,-160,-142,-142,-136,-134,-125,-114,-100,-86,-81,-66,-47,-37,-34,4,7,11,34,60,76,99,104,113,117,124,139,141,143,144,146,157,157,178,183,185,189,192,194,221,223,226,232,247,249,274,281,284,293,298,319,327,338,340,368,375,377,379,388,390,392,446,469,480,490};
		int[] input = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(input,0));
	}
	//This answer is very slow as well as stupid
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> result = new LinkedList<List<Integer>>();
//        HashSet<String> container = new HashSet<String>();
//        Arrays.sort(nums);
//        if(nums.length<4){
//        	return result;
//        }
//        else{
//            if(nums[0]*4>target||nums[nums.length-1]*4<target){
//            	return result;
//            }
//            else{
//                for (int i=0;i<nums.length;i++){
//                	if(nums[i]*4>target){
//                		continue;
//                	}
//                	else{
//                    	for(int j=i+1;j<nums.length;j++){
//                    		if(nums[i]+3*nums[j]>target){
//                    			continue;
//                    		}
//                    		else{
//                        		for(int k=j+1;k<nums.length;k++){
//                        			if(nums[i]+nums[j]+2*nums[k]>target){
//                        				continue;
//                        			}
//                        			else{
//                            			for(int m=k+1;m<nums.length;m++){
//                            				if(nums[i]+nums[j]+nums[k]+nums[m]==target){
//                            					char[] data = {(char)(nums[i]+'0'),(char)(nums[j]+'0'),(char)(nums[k]+'0'),(char)(nums[m]+'0')};
//                            					String dataS = String.valueOf(data);
//                            					if(container.contains(dataS)==false){
//                            						container.add(dataS);
//                            						List<Integer> newList = new LinkedList<Integer>();
//                            						newList.add(nums[i]);
//                            						newList.add(nums[j]);
//                            						newList.add(nums[k]);
//                            						newList.add(nums[m]);
//                            						result.add(newList);
//                            					}
//                            				}
//                            			}
//                        			}
//                        		}
//                    		}
//                    	}
//                	}
//                }
//            }
//            return result;
//        }
//    }
	
	//Here is a very fast method
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int second = 0, third = 0, nexti = 0, nextj = 0;
        for(int i=0, L=nums.length; i<L-3; i++) {
            if(nums[i]<<2 > target) return list; // return immediately
            for(int j=L-1; j>i+2; j--) {
                if(nums[j]<<2 < target) break; // break immediately
                int rem = target-nums[i]-nums[j];//if rem>sum,low++,if rem<sum,high--
                int lo = i+1, hi=j-1;
                while(lo<hi) {
                    int sum = nums[lo] + nums[hi];
                    if(sum>rem) --hi;
                    else if(sum<rem) ++lo;
                    else {
                        list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
                        while(++lo<=hi && nums[lo-1]==nums[lo]) continue; // avoid duplicate results
                        while(--hi>=lo && nums[hi]==nums[hi+1]) continue; // avoid duplicate results
                    }
                }
                while(j>=1 && nums[j]==nums[j-1]) --j; // skip inner loop
            }
            while(i<L-1 && nums[i]==nums[i+1]) ++i; // skip outer loop
        }
        return list;
    }
}
