
public class Solution {
	static int[] data;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(10));
	}
    //We can use memorization to solve the problem
 
    public static int numTrees(int n) {
        data = new int[n];
        data[0] = 1;
        return check(n);
    }
    private static int check(int n){
        if(n==0||n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else{
            int result = 0;
            for(int i = 1; i<=n/2; i++){
                if(data[i-1]==0){
                    data[i-1] = check(i-1);
                }
                if(data[n-i]==0){
                    data[n-i] = check(n-i);
                }
                result += data[i-1]*data[n-i]*2;
            }
            if(n%2==1){
                if(data[n/2]==0){
                    data[n/2] = check(n/2);
                }
                result += data[n/2]*data[n/2];
            }
            return result;
        }
    }
}
