
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfThree(243));
	}
    //So many corner cases!
    // public static boolean isPowerOfThree(int n) {
    //     if(n<=0){
    //         return false;
    //     }
    //     if(n>3){
    //         if(n%3!=0){
    //             return false;
    //         }
    //         else{
    //             n = n/3;
    //         }
    //     }
    //     int l = (int)Math.round((Math.log(n)/Math.log(3)));
    //     return (int)Math.pow(3,l)==n;
    // }
    
    //****There is a more efficient method
    public static boolean isPowerOfThree(int n) {
    // 1162261467 is 3^19,  3^20 is bigger than int  
    return ( n>0 &&  1162261467%n==0);
    }
}
