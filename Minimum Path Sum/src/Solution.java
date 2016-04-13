
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Use Dynamic Programming to solve this problem
    public static int minPathSum(int[][] grid) {
        if(grid==null){
            return 0;
        }
        else{
            int[][] container=new int[grid.length][grid[0].length];
            container[0][0]=grid[0][0];
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(i-1>=0&&j-1>=0){
                        container[i][j]=Math.min(container[i-1][j],container[i][j-1])+grid[i][j];
                    }
                    else if(i-1>=0){
                        container[i][j]=container[i-1][j]+grid[i][j];
                    }
                    else if(j-1>=0){
                        container[i][j]=container[i][j-1]+grid[i][j];
                    }
                }
            }
            return container[grid.length-1][grid[0].length-1];
        }
    }

}
