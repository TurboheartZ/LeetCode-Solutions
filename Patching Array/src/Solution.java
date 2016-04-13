
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //The Greedy problem is to find the best moves for the sub problem
    //Suppose our coverage now is max, then the best move for us is to patch "max+1" which makes the coverage extended to 
    //(1,2...,max)+max+1====> 1,2.....2*max+1
    //We need to consider the corner cases such as the max value of integer!
    public int minPatches(int[] nums, int n) {
        long cover = 0;
        int patch = 0;
        for(int i = 0; i<nums.length;){
            if(cover>=(long)n){
                break;
            }            
            long number = (long)nums[i];
            if(cover+1<number){
                patch++;
                cover = cover*2+1;
            }
            else{
                cover += number;
                i++;
            }
        }
        while(cover<(long)n){
            cover = cover*2+1;
            patch++;
        }
        return patch;
    }
}
