
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Build a matrix to record if we have visited this element as well as the longest path starting from it
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        else{
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] record = new int[row][col];
            int maxPath = 0;
            for(int i = 0; i<row; i++){
                for(int j = 0; j<col; j++){
                    if(record[i][j]==0){
                        //If we have visited the node, we do not need to start from it again
                        int len =1+findPath(matrix,record,i,j,row,col);
                        maxPath = Math.max(maxPath,len);
                    }
                }
            }
            return maxPath;
        }
    }
    private int findPath(int[][] matrix, int[][] record, int x, int y, int row, int col){
        int maxPath = 0;
        if(x-1>=0&&matrix[x-1][y]>matrix[x][y]){
            if(record[x-1][y]>0){
                maxPath = Math.max(maxPath,1+record[x-1][y]);
            }
            else{
                maxPath = Math.max(maxPath,1+findPath(matrix,record,x-1,y,row,col));                
            }
        }
        if(x+1<row&&matrix[x+1][y]>matrix[x][y]){
            if(record[x+1][y]>0){
                maxPath = Math.max(maxPath,1+record[x+1][y]);
            }
            else{
                maxPath = Math.max(maxPath,1+findPath(matrix,record,x+1,y,row,col));                
            }
        }
        if(y-1>=0&&matrix[x][y-1]>matrix[x][y]){
            if(record[x][y-1]>0){
                maxPath = Math.max(maxPath,1+record[x][y-1]);
            }
            else{
                maxPath = Math.max(maxPath,1+findPath(matrix,record,x,y-1,row,col));                
            }
        }
        if(y+1<col&&matrix[x][y+1]>matrix[x][y]){
            if(record[x][y+1]>0){
                maxPath = Math.max(maxPath,1+record[x][y+1]);
            }
            else{
                maxPath = Math.max(maxPath,1+findPath(matrix,record,x,y+1,row,col));                
            }
        }
        record[x][y] = maxPath;
        //Use record not only shows if we visited the node, also records the longest path starting from this node
        return maxPath;
    }
}
