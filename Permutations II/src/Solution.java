import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = {3,3,1,2,3,2,3,1};
		System.out.println(permuteUnique(in));
	}
	//****New DFS method
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            //We just go to the bottom, at every level, we add one number, we do not need to trace back
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            //!used[i-1] means nums[i-1] is used since after the dfs, we set the used[i-1] back to false again
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
	
	
	//****Previous stupid method*****
	
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        if(nums.length==0){
//            return null;
//        }
//        else{
//            boolean[] visited = new boolean[nums.length];
//            return generate(nums,visited);
//        }
//    }
//    private static List<List<Integer>> generate(int[] nums, boolean[] visited){
//        if(nums.length==0){
//            return null;
//        }
//        else if(nums.length==1){
//            List<List<Integer>> result = new ArrayList<List<Integer>>();
//            List<Integer> r = new ArrayList<Integer>();
//            r.add(nums[0]);
//            result.add(r);
//            return result;
//        }
//        else{
//            List<List<Integer>> result = new ArrayList<List<Integer>>();
//            //We do not need to use hashset to remove duplicate list, we only need to remove duplicate integer in this level
//            //HashSet<List<Integer>> filter = new HashSet<List<Integer>>();
//            HashSet<Integer> f = new HashSet<Integer>();
//            for(int i = 0; i<nums.length; i++){
//                if(visited[i]==false&&f.contains(nums[i])==false){
//                    f.add(nums[i]);
//                    visited[i] = true;
//                    //******This part we donot need to trace back, we can directly go to the bottom with adding one number at every level!!!!!!!!!
//                    List<List<Integer>> data = generate(nums,visited);
//                    for(List<Integer> x: data){
//                        x.add(nums[i]);
//                        result.add(x);
//                    }
//                    visited[i] = false;
//                }
//            }
//            if(result.size()>0){
//            	return result;
//            }
//            else{
//                List<Integer> r = new ArrayList<Integer>();
//                result.add(r);
//                return result;
//            }
//        }
//    }
}
