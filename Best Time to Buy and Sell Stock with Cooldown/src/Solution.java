
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Can we do this iterately using Greedy?
	//****4 states: sell, buy, hold, cooldown
    private class Stock{
        public int earned = 0;
        public int bought = 0;
        public int profit(){
            return this.earned-this.bought;
        }
    }
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        else{
            int max = 0;
            Stock buy = new Stock();
            buy.bought = prices[0];
            Stock sell = new Stock();
            Stock hold = new Stock();
            hold.bought = prices[0];
            Stock cooldown = new Stock();
            for(int i = 1; i<prices.length; i++){
                Stock buy1 = new Stock();
                Stock sell1 = new Stock();
                Stock hold1 = new Stock();
                Stock cooldown1 = new Stock();
                //Calculate the buy stock
                buy1 = cooldown;
                buy1.bought = prices[i];
                //Calculate the sell stock
                if(hold.earned+prices[i]-hold.bought>=buy.earned+prices[i]-buy.bought){
                    sell1.earned = hold.earned+prices[i]-hold.bought;
                    sell1.bought = 0;
                }
                else{
                    sell1.earned = buy.earned+prices[i]-buy.bought;
                    sell1.bought = 0;
                }
                cooldown1.earned = Math.max(cooldown.earned,sell.earned);
                //Calculate the nothing stock
                if(buy.earned-buy.bought>=hold.earned-hold.bought){
                    hold1 = buy;
                }
                else{
                    hold1 = hold;
                }
                max = Math.max(buy1.profit(),Math.max(sell1.profit(),Math.max(cooldown1.profit(),hold1.profit())));
                buy = buy1;
                sell = sell1;
                cooldown = cooldown1;
                hold = hold1;
            }
            return max;
        }
    }
}
