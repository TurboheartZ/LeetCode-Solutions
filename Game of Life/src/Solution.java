
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    //This problem is to count the sum of peripheral cells for one cell
    //We can use -1 to denote the wud-to-die cell and use Math.abs to add it
    public static void gameOfLife(int[][] board) {
        int sum = 0;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                sum = 0;
                if(i-1>=0){
                    sum+=Math.abs(board[i-1][j])%2;
                    if(j-1>=0){
                        sum+=Math.abs(board[i-1][j-1])%2;
                    }
                    if(j+1<board[0].length){
                        sum+=Math.abs(board[i-1][j+1])%2;
                    }
                }
                if(i+1<board.length){
                    sum+=Math.abs(board[i+1][j])%2;
                    if(j-1>=0){
                        sum+=Math.abs(board[i+1][j-1])%2;
                    }
                    if(j+1<board[0].length){
                        sum+=Math.abs(board[i+1][j+1])%2;
                    }
                }                
                if(j-1>=0){
                    sum+=Math.abs(board[i][j-1])%2;
                }
                if(j+1<board[0].length){
                    sum+=Math.abs(board[i][j+1])%2;
                }
                //Check the current state and predict the next state
                if(board[i][j]==0){
                    if(sum==3){
                        board[i][j] = 2;
                    }
                }
                else{
                    if(sum<2){
                        board[i][j] = -1;
                    }
                    else if(sum>3){
                        board[i][j] = -1;
                    }
                }
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]==-1){
                    board[i][j] = 0;
                }
                else if(board[i][j]==2){
                    board[i][j] = 1;
                }
            }
        }
    }
}
