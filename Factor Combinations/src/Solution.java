import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFactors(32));
	}
    //We only need to calculate (1,sqrt(n)]
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n<=1){
            return res;
        }
        else{
            DFS(res, new ArrayList<Integer>(),n);
            return res;
        }
    }
    private static void DFS(List<List<Integer>> res, List<Integer> prev, int n){
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i==0&&(prev.size()==0||(prev.size()>0&&i>=prev.get(prev.size()-1)))){
                prev.add(i);
                DFS(res,prev,n/i);
                prev.remove(prev.size()-1);
            }
        }
        if(prev.size()>0){
            prev.add(n);
            res.add(new ArrayList<Integer>(prev));//If we do not use this new arraylist, when we remove the last element in the prev, the res will change
            prev.remove(prev.size()-1);
            return;
        }        
    }
}
