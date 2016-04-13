import java.util.*;
public class Solution {

    //****Recursive solution****
    public int coinChange(int[] coins, int amount) {
        int[] num = new int[amount+1];
        return change(coins, amount, num);
    }
    
    private int change(int[] coins, int amount, int[] num){
        if(amount<0){
            return -1;
        }
        else if(amount==0){
            return 0;
        }
        else{
            if(num[amount]!=0){
                return num[amount];
            }
            else{
                int min = Integer.MAX_VALUE;
                for(int c : coins){
                    int rem = amount - c;
                    int r = change(coins, rem, num);
                    if(r>=0&&r<min){
                        min = r;
                    }
                }
                if(min==Integer.MAX_VALUE){
                    //This step is important, since we have calculated that this amount can not be changed, we do not need to do it again
                    num[amount] = -1;
                    return -1;
                }
                else{
                    num[amount] = min+1;
                    return num[amount];
                }
            }
        }
    }
    //****Iterative Solution****
    //Iterative solution
    //It is a bottom-up solution
    public int coinChangeIterative(int[] coins, int amount) {
        if(amount<0){
            return -1;
        }
        else if(amount==0){
            return 0;
        }
        else{
            int[] dp = new int[amount+1];
            int sum = 1;
            //Add up from 0 to amount
            //If amount-coins[i] exists, we can know dp[amount]
            while(sum<=amount){
                int min = Integer.MAX_VALUE;
                for(int c : coins){
                    if(sum==c){
                        dp[sum] = 1;
                        min = 0;
                        break;
                    }
                    else if(sum>c&&dp[sum-c]>0){
                        min = Math.min(dp[sum-c],min);
                    }
                }
                if(min!=Integer.MAX_VALUE){
                    dp[sum] = min+1;
                }
                else{
                    dp[sum] = -1;
                }
                sum++;
            }
            return dp[amount];
        }
    }
}
