import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        else{
            HashMap<Integer, Integer> ugly = new HashMap<Integer, Integer>();
            ugly.put(1,1);
            int x = 1, y = 1, z = 1;
            for(int i = 2; i<=n; i++){
                int xx = ugly.get(x)*2;//The new candidates must be the product of previous ugly number and 2 or 3 or 5
                int yy = ugly.get(y)*3;
                int zz = ugly.get(z)*5;
                int min =  0;
                if(xx<=yy){
                    if(xx<=zz){
                        min = xx;
                        x++;
                        if(xx==zz) z++;//If equals, both ++
                    }
                    else{
                        min = zz;
                        z++;
                    }
                    if(xx==yy) y++;
                }
                else{
                    if(yy<=zz){
                        min = yy;
                        y++;
                        if(yy==zz) z++;
                    }
                    else{
                        min = zz;
                        z++;
                    }                    
                }
                ugly.put(i,min);
            }
            return ugly.get(n);
        }
    }
}
