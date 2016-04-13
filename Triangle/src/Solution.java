import java.util.Arrays;
import java.util.List;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int triangle(List<List<Integer>> triangle){
		int size = triangle.size();
		int[] dp = new int[size];
		dp[0] = triangle.get(0).get(0);
		for(int i = 1;i<size;i++){
			for(int j = i;j>=0;j--){
				if(j==0){
					dp[0] = dp[0] + triangle.get(i).get(0);
				}
				else if(j==i){
					dp[j] = dp[j-1] + triangle.get(i).get(j);
				}
				else{
					dp[j] = Math.min(dp[j-1], dp[j]) + triangle.get(i).get(j);
				}
			}
		}
		Arrays.sort(dp);
		return dp[0];
	}

}
