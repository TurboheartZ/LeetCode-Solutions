
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = new int[2][2];
		setZeroes(data);
		long a=10;
		System.out.println(a|2);
	}
    public  static void setZeroes(int[][] matrix) {
        //Push the zero unit to the uppermost and leftmost and use that to determine which
        //row and col should be set to 0
        int row=matrix.length;
        int col=matrix[0].length;
        int i,j;
        int x=0;
        int y=0;
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                    if(i==0){
                        x=1;
                    }
                    if(j==0){
                        y=1;
                    }
                }
            }
        }
        for(i=1;i<row;i++){
            if(matrix[i][0]==0){
                for(j=0;j<col;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(i=1;i<col;i++){
            if(matrix[0][i]==0){
                for(j=0;j<row;j++){
                    matrix[j][i]=0;
                }
            }
        }
        if(x==1){
            for(j=0;j<col;j++){
                matrix[0][j]=0;
            }
        }
        if(y==1){
            for(j=0;j<row;j++){
                matrix[j][0]=0;
            }
        }
    }
}
