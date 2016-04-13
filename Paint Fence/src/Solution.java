
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numWays(int n, int k) {
	    if(n == 0) return 0;
	    else if(n == 1) return k;
	    int diffColorCounts = k*(k-1);
	    int sameColorCounts = k;
	    for(int i=2; i<n; i++) {
	        int temp = diffColorCounts;
	        diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
	        sameColorCounts = temp;
	    }
	    return diffColorCounts + sameColorCounts;
	}
	//Use DP
    public int numWays2(int n, int k) {
        if(n==0||k==0){
            return 0;
        }
        else if(n==1){
            return k;
        }
        else{
            int[] dp = new int[n+1];
            dp[1] = k;
            dp[2] = k*k;
            for(int i = 3;i<=n;i++){
                dp[i] = (k-1)*(dp[i-1]+dp[i-2]);
            }
            return dp[n];
        }
    }
}
