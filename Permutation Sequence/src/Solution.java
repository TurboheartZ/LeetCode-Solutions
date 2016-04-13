import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Works like binary search
    //K/(n-1)! is the index of the highest number in the list
    //Do not forget to remove the number from the list, others keep their order
    public String getPermutation(int n, int k) {
        int p = 1;
        List<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i<=n; i++){
            num.add(i);
            p *= i;
        }
        if(k>p){
            return "";
        }
        else{
            StringBuilder result = new StringBuilder();
            k = k-1;
            while(k>0){
                int pp = p/n;
                int index = k/(pp);
                result.append(num.get(index));
                num.remove(index);
                k = k-pp*index;
                p = pp;
                n=n-1;
            }
            if(num.size()>0){
                for(int i = 0; i<num.size(); i++){
                    result.append(num.get(i));
                }
            }
            return result.toString();
        }
    }
}
