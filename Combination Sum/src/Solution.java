import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] can = {2,3,6,7};
		int tar = 7;
		System.out.println(combinationSum(can,tar));
	}
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        if(candidates.length<1){
            return data;
        }
        else{
            Arrays.sort(candidates);
            List<Integer> prev = new ArrayList<Integer>();
            return iteration(candidates, target, 0, prev);
        }
    }
    public static List<List<Integer>> iteration (int[] candidates, int target, int begin, List<Integer> prev){
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        if(begin >= candidates.length){
            return data;
        }
        else if(begin == candidates.length-1){
            if(target%candidates[begin]==0){
                for(int i =0;i<target/candidates[begin];i++){
                    prev.add(candidates[begin]);
                }
                data.add(prev);
                return data;
            }
            else{
                return data;
            }
        }
        else{
            if(candidates[begin]==candidates[begin+1]){
                return iteration(candidates, target, begin+1, prev);
            }
            else{
                for(int i = 0;i<=target/candidates[begin];i++){
                    int nextTarget = target - i*candidates[begin];
                    List<Integer> nextPrev = new ArrayList<Integer>();
                    nextPrev.addAll(prev);
                    for(int j = 0;j<i;j++){
                        nextPrev.add(candidates[begin]);
                    }
                    if(nextTarget==0){
                    	data.add(nextPrev);
                    }
                    else{
                    	data.addAll(iteration(candidates, nextTarget, begin+1, nextPrev));
                    }
                }
                return data;
            }
        }
    }
}
