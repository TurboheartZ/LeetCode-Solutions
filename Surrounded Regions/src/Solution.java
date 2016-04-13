
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //First find the Os on the edge and do DFS
    public void solve(char[][] board) {
        if(board.length<=1||board[0].length<=1){
            return;
        }
        else{
            int row = board.length;
            int col = board[0].length;
            //Find Os on edges
            int i = 0;
            int j = 0;
            for(j=0; j<col; j++){
                if(board[0][j]=='O'){
                    board[0][j]='M';
                    DFS(board,0,j,row,col);
                }
            }
            for(j=0; j<col; j++){
                if(board[row-1][j]=='O'){
                    board[row-1][j]='M';
                    DFS(board,row-1,j,row,col);
                }
            }
            for(i=1; i<row-1; i++){
                if(board[i][0]=='O'){
                    board[i][0]='M';
                    DFS(board,i,0,row,col);
                }
            }
            for(i=1; i<row-1; i++){
                if(board[i][col-1]=='O'){
                    board[i][col-1]='M';
                    DFS(board,i,col-1,row,col);
                }
            }
            for(i = 0; i<row; i++){
                for(j =0; j<col; j++){
                    if(board[i][j]=='O'){
                        board[i][j] = 'X';
                    }
                    else if(board[i][j]=='M'){
                        board[i][j] = 'O';
                    }
                }
            }
        }
    }
    
    private void DFS(char[][] board, int i, int j, int row, int col){
        if(i-1>0&&board[i-1][j]=='O'){
            board[i-1][j]='M';
            DFS(board,i-1,j,row,col);
        }
        if(i+1<row-1&&board[i+1][j]=='O'){//No need do dfs to the points on the edges
            board[i+1][j]='M';
            DFS(board,i+1,j,row,col);
        }
        if(j-1>0&&board[i][j-1]=='O'){
            board[i][j-1]='M';
            DFS(board,i,j-1,row,col);
        }
        if(j+1<col-1&&board[i][j+1]=='O'){
            board[i][j+1]='M';
            DFS(board,i,j+1,row,col);
        }
    }
}
