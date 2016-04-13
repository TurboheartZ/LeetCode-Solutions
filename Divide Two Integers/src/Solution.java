
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(Integer.MAX_VALUE);
		int result = -1;//divide(-1,1);
		System.out.println(result);
	}
    //Note the corner situations!
    //Since the range of MAX_VALUE is less than MIN_VALUE, we can turn both into negative number
    public static int divide(int dividend, int divisor) {
        final int MAX = 0x7fffffff;
        final int MIN = 0x80000000;
        if(divisor==0 || (divisor==-1 && dividend==MIN)) return MAX;
        int sign = (dividend>=0 && divisor>0 || dividend<=0 && divisor<0) ? 1 : -1;
        dividend = dividend>0 ? -dividend : dividend;
        divisor = divisor>0 ? -divisor : divisor;
        if(dividend>divisor) return 0;
        if(divisor==-1) return sign==1 ? -dividend : dividend;
        int res = 0; // final result
        while(dividend<=divisor) {
            int divisorCurrent = divisor;
            int resCurrent = 1;
            while(divisorCurrent>dividend>>1) {
                divisorCurrent = divisorCurrent<<1;
                resCurrent = resCurrent<<1;
            }
            res += resCurrent;
            dividend -= divisorCurrent;
        }
        return sign==1 ? res : -res;
    }  
}
