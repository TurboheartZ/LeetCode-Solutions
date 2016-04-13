import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,2},{3,4}};
		System.out.println(spiralOrder(input));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
	    List<Integer> list = new ArrayList<Integer>();
	    if(matrix.length==0) return list;
	    int row=matrix.length,col=matrix[0].length,times=(Math.min(row,col)+1)/2;
	    for(int t=0;t<times;t++){
	        for(int i=t;i<col-t;i++) list.add(matrix[t][i]);
	        for(int i=t+1;i<row-t;i++) list.add(matrix[i][col-t-1]);
	        if(row-t-1>t){
	            for(int i=col-t-2;i>=t;i--) list.add(matrix[row-t-1][i]);
	        }
	        if(t<col-t-1){
	            for(int i=row-t-2;i>t;i--) list.add(matrix[i][t]);   
	        }
	    }
	    return list;
	}
}
