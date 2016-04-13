import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //No duplicate numbers
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<k*(k+1)/2||n>45){//1,2,3...k is the least combination
            return result;
        }
        else{
            List<Integer> prev = new ArrayList<Integer>();
            return iteration(k, n, 1, prev);
        }
    }
    public List<List<Integer>> iteration(int k, int n, int begin, List<Integer> prev){
       List<List<Integer>> data = new ArrayList<List<Integer>>(); 
       if(prev.size()==k-1){
           if(n>=begin&&n<=9){
               prev.add(n);
               data.add(prev);
           }
           return data;
       }
       else{
           if(begin>8){
               return data;//At least we need 2 more numbers
           }
           else{
               //Without the Element
                if(n>=2*begin+3){
                    data.addAll(iteration(k,n,begin+1,prev));
                }
                //With this Element
                if(n-begin>=begin+1){
                    List<Integer> nextPrev = new ArrayList<Integer>(prev);
                    nextPrev.add(begin);
                    data.addAll(iteration(k,n-begin,begin+1,nextPrev));
                }
                return data;
           }
       }
    }
}
