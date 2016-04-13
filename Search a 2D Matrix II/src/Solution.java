
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int tar = 15;
		System.out.println(searchMatrix(input,tar));
	}
    //We start from the top right num, if target>num, then the whole role is eliminated, if target<num, then the whole column is eliminated.
    public static boolean  searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row<1){
            return false;
        }
        else{
            int col = matrix[0].length;
            if(col<1){
                return false;
            }
            else{
                int n = col-1;
                int m = 0;
                boolean result = false;
                while(n>=0&&m<row){
                    if(target==matrix[m][n]){
                        result = true;
                        break;
                    }
                    else if(target>matrix[m][n]){
                        m++;
                    }
                    else{
                        n--;
                    }
                }
                return result;
            }
        }
    }
}
