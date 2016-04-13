import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,3,1};
		System.out.println(verifyPreorder(input));
	}
    public static boolean verifyPreorder(int[] preorder) {
        if(preorder.length==0){
            return true;
        }
        else{
            Stack<Integer> data = new Stack<Integer>();
            int root = Integer.MIN_VALUE;
            for(int i = 0; i<preorder.length; i++){
                if(data.isEmpty()==true){
                    data.add(preorder[i]);
                }
                else{
                    if(preorder[i]<=root){
                        return false;
                    }
                    while(data.isEmpty()==false&&data.peek()<preorder[i]){
                        root=data.pop();
                    }
                    data.push(preorder[i]);
                }
            }
            return true;
        }
    }
}
