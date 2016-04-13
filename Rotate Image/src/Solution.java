
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static void rotate(int[][] matrix) {
        //original location(x,y)
        //new location(y,row-1-x)
        //Since we need to do this rotation in-place, we can achieve this step by step
        //First change from(x,y)to(y,x)
        //Then from(y,x)to(y,row-1-x)
        int n=matrix.length;
        if(n>1){
            int i;
            int j;
            int mid=0;
            //Exchange from(x,y)to(y,x)
            for(i=0;i<n;i++){
                for(j=i+1;j<n;j++){
                    mid=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=mid;
                }
            }
            //Exchange from (y,x)to(y,n-1-x)
            for(i=0;i<n;i++){
                for(j=0;j<n/2;j++){
                    mid=matrix[i][j];
                    matrix[i][j]=matrix[i][n-1-j];
                    matrix[i][n-1-j]=mid;
                }
            }
        }
    }

}
