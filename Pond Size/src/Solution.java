import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
		System.out.println(pond(input));
	}
	public static List<Integer> pond(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		List<Integer> pondSize = new LinkedList<Integer>();
		if(row==0||col==0){
			return pondSize;
		}
		else{
			int i,j;
			for(i = 0; i<row; i++){
				for(j = 0; j<col; j++){
					if(matrix[i][j]==0){
						pondSize.add(computeSizes(matrix,i,j));
					}
				}
			}
			return pondSize;
		}		
	}
	private static int computeSizes(int matrix[][], int row, int col){//DFS Search
		if(row<0||row>=matrix.length||col<0||col>=matrix[row].length||matrix[row][col]!=0){
			return 0;
		}
		else{
			matrix[row][col] = -1;//mark it if visited
			int size = 1;
			int i,j;
			for(i = row-1; i<= row+1; i++){
				for(j = col - 1;j<= col+1; j++){
					size += computeSizes(matrix,i,j);
				}
			}
			return size;
		}
	}
}
