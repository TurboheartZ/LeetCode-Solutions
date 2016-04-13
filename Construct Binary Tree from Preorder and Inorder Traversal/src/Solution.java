import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //1, The first element of inorder array is the root of the tree. Which can be used to divide the preorder array into left and right part.
 //2, According to the inorder array, we can obtain the level information, i.e., the next element either is the right cousin or the child 
 //element of the previous element.
 //3, To determine which relative indeed, we can use the preorder array to check. If the next element appears before the parent node of the
 //previous element, it should be the child of the previous node. Else, it may be the right cousin of the element.
 
//1）先序遍历的第一个结点总是根结点。如上图中的二叉树，根结点为7，也是先序遍历的第一个值。先序遍历时父亲结点总是在孩子结点之前遍历。
//2）可以观察到在中序遍历中，7是第4个值（从0开始算起）。由于中序遍历顺序为：左子树，根结点，右子树。所以7左边的{4,10,3,1} 这四个结点属于左子树，而根结点7右边的{11,8,2}属于右子树。
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {4,2,6,5,1,7,3,9,8,10};
		int[] inorder = {1,2,4,5,6,3,7,8,9,10};
		int[] result = Arrays.copyOfRange(preorder, 0, 1);
		System.out.println(result[0]);
		HashMap<Integer,Integer> filter = new HashMap<Integer,Integer>();
		filter.put(1, 0);
		System.out.println(filter.containsKey(1));
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = null;
        if(preorder.length>=1&&preorder.length==inorder.length){
            result = next(preorder,inorder);
        }
        return result;
    }
    public TreeNode next(int[] preorder, int[] inorder){
        if(inorder.length==1){
            TreeNode newNode = new TreeNode(preorder[0]);
            return newNode;
        }
        else if(inorder.length>1){
            TreeNode newNode = new TreeNode(preorder[0]);    
            //Left Side
            int len = index(inorder,preorder[0]);
            int[] newInorder = Arrays.copyOfRange(inorder,0,len);
            int[] newPreorder = Arrays.copyOfRange(preorder,1,1+len);
            newNode.left = next(newPreorder,newInorder);
            //Right side
            newInorder = Arrays.copyOfRange(inorder,len+1,inorder.length);
            newPreorder = Arrays.copyOfRange(preorder,len+1,preorder.length);
            newNode.right = next(newPreorder,newInorder);
            return newNode;
        }
        else{
            return null;
        }
    }
    public int index(int[] nums, int val){
        int i = 0;
        for(i = 0;i<nums.length;i++){
            if(nums[i]==val){
                break;
            }
        }
        return i;
    }

}
