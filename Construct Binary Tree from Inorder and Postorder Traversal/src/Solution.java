import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    HashMap<Integer,Integer> filter = new HashMap<Integer,Integer>();//This hashmap is used to index
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length<1){
            return null;
        }
        else if(inorder.length==1){
            TreeNode root = new TreeNode(inorder[0]);
            return root;
        }
        else{
            for(int i = 0; i<inorder.length;i++){
                filter.put(inorder[i],i);
            }
            return constructTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        }
    }
    public TreeNode constructTree(int[] inorder, int[] postorder, int inbegin, int inend, int postbegin, int postend){
        if(inbegin == inend){
            TreeNode newNode = new TreeNode(inorder[inbegin]);
            return newNode;
        }
        else if(inbegin < inend){
            TreeNode newNode = new TreeNode(postorder[postend]);
            int index = filter.get(postorder[postend]);
            //Right side first, since the postorder is left-->right-->root
            int ibegin = index + 1;
            int iend = inend;
            int pend = postend - 1;
            int pbegin = pend - (iend - ibegin);
            newNode.right = constructTree(inorder, postorder, ibegin, iend, pbegin, pend);
            //Left side
            ibegin = inbegin;
            iend = index - 1;
            pend = pbegin - 1;
            pbegin = pend - (iend - ibegin);
            newNode.left = constructTree(inorder, postorder, ibegin, iend, pbegin, pend);
            return newNode;
        }
        else{
            return null;
        }
    }
}
