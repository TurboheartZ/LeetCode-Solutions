import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Recursive method, 2^n time complexity
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n==0){
            return result;
        }
        else{
            return next("",n,n);
        }
    }
    private List<String> next(String s, int lp, int np){
        List<String> result = new ArrayList<String>();
        if(lp==0){
            for(int i = 0; i<np; i++){
                s += ")";
            }
            result.add(s);
            return result;
        }    
        else{
            List<String> fromNext = new ArrayList<String>();
            if(lp<np){
                fromNext.addAll(next(s+"(",lp-1,np));
                fromNext.addAll(next(s+")",lp,np-1));
            }
            else if(lp==np){
                fromNext.addAll(next(s+"(",lp-1,np));
            }
            return fromNext;
        }
    }
}
