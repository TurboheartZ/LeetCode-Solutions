
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
    int[][] mp;//Use this mp to avoid duplicate calculations
    
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        else{
            int row = matrix.length;
            int col = matrix[0].length;
            mp = new int[row][col];
            int max = 0;
            int maxS = 0;//Use this maxS to avoid calculating the square which will not be larger than the max value
            for(int i = 0; i<row; i++){
                for(int j = 0; j<col; j++){
                    if(matrix[i][j]=='1'){
                        int dep = helper(i,j,col,matrix);
                        if(dep<=maxS){
                            continue;
                        }
                        int wid = dep;
                        int k =0;
                        for(k = 1; k<dep; k++){
                            if(i+k>=row){
                                k--;
                                break;
                            }
                            else{
                                if(k>=wid){
                                    break;
                                }    
                                else{
                                    wid = Math.min(wid,helper(i+k,j,col,matrix));
                                }
                            }
                        }
                        int s = Math.min(k+1,wid);
                        if(s>maxS){
                            maxS = s;
                            max = s*s;
                        }
                    }
                }
            }
            return max;
        }
    }
    
    private int helper(int x, int y, int col, char[][] matrix){
        if(y>=col){
            return 0;
        }
        if(mp[x][y]!=0){
            return mp[x][y];
        }
        if(matrix[x][y]=='0'){
            //Update mp to avoid duplicate calculation
            mp[x][y] = -1;
            return 0;
        }
        else{
            //Update mp to avoid duplicate calculation
            mp[x][y] = 1+helper(x,y+1,col,matrix);
            return mp[x][y];
        }
    }
}
