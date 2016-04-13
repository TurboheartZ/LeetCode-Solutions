
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //It is not a easy sorting problem, since the date keeps going
    //buying is always prior to selling
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        else{
            int max = 0;
            int small = 0;
            int big = 0;
            for(int x = 1; x<prices.length; x++){
                if(prices[x]>prices[big]){
                    if(prices[x]-prices[small]>max){
                        max = prices[x]-prices[small];
                        big = x;
                    }
                }
                if(prices[x]<prices[small]){//If new small number appears, we hold the previous max value and start from this new value
                    small = x;
                    big = x;//Big index is always after the Small index
                }
            }
            return max;
        }
    }
}
