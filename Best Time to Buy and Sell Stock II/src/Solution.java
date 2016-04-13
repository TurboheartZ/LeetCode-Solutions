
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//*****This is a smarter answer
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1;i<prices.length;i++){
            profit += Math.max(0,prices[i]-prices[i-1]);//For example: 1,2,3----->(2-1)+(3-2)==(3-1)
        }
        return profit;
    }
	
	
	//*****This is a very stupid answer*********
    //Once the next element is a drop, we sell this element
    //Once the next element is a rise, we buy this element
//    public int maxProfit(int[] prices) {
//        if(prices.length<=1){
//            return 0;
//        }
//        else{
//            int buy = -1;
//            int sum = 0;
//            int x=0;
//            for(x = 0;x<prices.length-1; x++){
//                if(buy<0){
//                    //Means not buy
//                    if(prices[x+1]>prices[x]){
//                        buy = x;
//                    }
//                }
//                else{
//                    if(prices[x+1]<=prices[x]){
//                        sum += prices[x]-prices[buy];
//                        buy = -1;
//                    }
//                }
//            }
//            if(buy>=0){
//                sum += prices[x]-prices[buy];
//            }
//            return sum;
//        }
//    }
}
