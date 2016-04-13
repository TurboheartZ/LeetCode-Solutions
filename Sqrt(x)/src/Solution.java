
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2147395599;
		System.out.println(mySqrt(x));
	}
    public static int mySqrt(int x) {
        if(x<=0||x==1){
            return x;
        }
        else{
            int lo;
            int hi;
            if(x<1){
                return 0;
            }
            else{
                lo = 1;
                hi = x>4?x/2+1:x;
            }
            int mid = 0;
            while(lo<hi-1){
                mid = (lo+hi)/2;
                if(mid<x/mid){
                    lo = mid;
                }
                else if(mid>x/mid){//This is to overcome mid*mid overwhelmed situation
                    hi = mid;
                }
                else{
                    break;
                }
            }
            return (lo+hi)/2;
        }
    }
    
//********This is a pretty fancy and fast method***********
    //For those are the multiple of 4, result = 2*mySqrt(x/4)
    //For those are not, result = 1 + 2*mySqrt(x/4);
    public static int mySqrt1(int x) {
        if(x < 4) return x == 0 ? 0 : 1;
        int res = 2 * mySqrt(x/4);
        if((res+1) * (res+1) <= x && (res+1) * (res+1) > 0) return res+1;
        return res;
    }
}
