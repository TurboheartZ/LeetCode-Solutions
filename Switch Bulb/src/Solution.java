
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//It is just a problem find factors of a certain number
    //Take number '6' as example, 6 = 1*6 or 2*3 which means it can be toggled 4 times which means off
    //Since factors appear in pairs, thus only the factors are the same can make we toggle the bulb in odd times
    //Thus we need to find the number of n^2 in the bulb indexes
    public int bulbSwitch(int n) {
        if(n<=0){
            return 0;
        }
        else{
            return (int)Math.sqrt(n);
        }
    }
}
