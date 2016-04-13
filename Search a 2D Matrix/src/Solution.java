
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target=13;
		System.out.println(searchMatrix(input,target));
	}
    public static boolean searchMatrix(int[][] matrix, int target) {
        //We can simplify this problem into a sort-number problem and use binary search to solve it
        int row=matrix.length;
        int col=matrix[0].length;
        if(target<=matrix[0][0]){
            return matrix[0][0]==target?true:false;
        }
        boolean result=false;
        if(target>=matrix[row-1][0]){
            for(int i=0;i<col;i++){
                if(matrix[row-1][i]==target){
                    result=true;
                    break;
                }
            }
            return result;
        }
        else{
            int first=0;
            int last=row-1;
            int mid;
            while(last-first>1){
                mid=(last+first)/2;
                if(target>matrix[mid][0]){
                    first=mid;
                }
                else if(target==matrix[mid][0]){
                    result=true;
                    break;
                }
                else{
                    last=mid;
                }
            }
            if(result==true){
                return true;
            }
            else{
                if(target>=matrix[first][col-1]){
                    return target==matrix[first][col-1]?true:false;
                }
                else{
                    int r=first;
                    first=0;
                    last=col-1;
                    while(last-first>1){
                        mid=(last+first)/2;
                        if(target>matrix[r][mid]){
                            first=mid;
                        }
                        else if(target==matrix[r][mid]){
                            result=true;
                            break;
                        }
                        else{
                            last=mid;
                        }
                    }
                    return result;
                }
            }
        }
    }
}
