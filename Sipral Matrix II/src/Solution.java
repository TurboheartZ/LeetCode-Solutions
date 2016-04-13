
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 4;
		System.out.println(generateMatrix(input));
	}
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n>0){
            int num=1;
            for(int i=0;i<=n/2;i++){
                int j,k;
                for(j=i;j<=n-i-1;j++){
                    if(num<=n*n){
                        result[i][j] = num++;
                    }
                    else{
                        return result;
                    }
                }
                for(k=i+1;k<=n-i-1;k++){
                    if(num<=n*n){
                        result[k][n-i-1] = num++;
                    }
                    else{
                        return result;
                    }
                }
                for(j=n-i-2;j>=i;j--){
                    if(num<=n*n){
                        result[n-i-1][j] = num++;
                    }
                    else{
                        return result;
                    }
                }
                for(k=n-i-2;k>i;k--){
                    if(num<=n*n){
                        result[k][i] = num++;
                    }
                    else{
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
