import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
	}
    //Since in the previous problem, we can avoid duplicates since a number can be used for multiple times
    //In this problem, since one number can be used for 1 time, we can not avoid duplicates naturally, thus, we can achieve that through
    //HashMap
    HashMap<List<Integer>,Integer> filter = new HashMap<List<Integer>,Integer>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates.length<1){
            return result;
        }
        else{
            List<Integer> prev = new ArrayList<Integer>();
            if(target==0){
                prev.add(0);
                result.add(prev);
                return result;
            }
            else{
                Arrays.sort(candidates);
                return iteration(candidates, target, 0, prev);
            }
        }
    }
    public List<List<Integer>> iteration (int[] candidates, int target, int begin, List<Integer> prev){
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        if(target==0){
            //Check if duplicates before return
            if(filter.containsKey(prev)==true){
                return data;
            }
            else{
                filter.put(prev,1);
                data.add(prev);
                return data;
            }
        }
        else{
            if(begin<=candidates.length-1){
                data.addAll(iteration(candidates, target, begin+1, prev));//Without this element
                if(target-candidates[begin]==0||(begin+1<=candidates.length-1)&&target-candidates[begin]>=candidates[begin+1]){
                    List<Integer> nextPrev = new ArrayList<Integer>(prev);
                    nextPrev.add(candidates[begin]);
                    data.addAll(iteration(candidates, target-candidates[begin], begin+1, nextPrev));//With this element                    
                }
            }
            return data;
        }
    }
}
