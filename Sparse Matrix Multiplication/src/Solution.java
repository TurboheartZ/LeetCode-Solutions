
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[][] multiply(int[][] A, int[][] B) {
        if(A.length==0||B.length==0){
            return new int[0][0];
        }
        else if(A[0].length==0||B[0].length==0||A[0].length!=B.length){
            return new int[0][0];
        }
        else{
            int[][] result = new int[A.length][B[0].length];
            //Use the elements in matrix A rather than matrix result, this saves time
            for(int i= 0; i<A.length; i++){
                for(int j = 0; j<A[0].length; j++){
                    if(A[i][j]!=0){
                        for(int k = 0; k<result[0].length; k++){
                            if(B[j][k]!=0){
                                result[i][k] += A[i][j]*B[j][k];
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}
