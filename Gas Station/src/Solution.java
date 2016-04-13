import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int tank = 0;
        int cur = 0;
        for(int i = 0; i<cost.length; i++){//If tank==0, means we can only start from i+1; since from 0 to i-1, the sum>=0 
            tank += gas[i]-cost[i];
            cur += tank;
            if(tank<0){
                index = i+1;
                tank =  0;
            }
        }
        return cur<0?-1:index;
    }
}
