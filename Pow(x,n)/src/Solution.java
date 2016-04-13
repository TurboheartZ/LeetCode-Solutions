
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            n = -n;
        }
        if(n==0){
            return 1;
        } 
        else if(n==1){
            return x;
        }
        else{
            int a = n/2;
            int b = n%2;
            double result = myPow(x,a);
            return result*result*myPow(x,b);
        }
     }
}
