
public class Solution {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //We need to utilize the BST character to simplify the calculation
    //Binary Search
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        }
        else{
            if(root.val==p.val){
                TreeNode result = root.right;
                if(result==null){
                    return null;
                }
                while(result.left!=null){
                    result = result.left;
                }
                return result;
            }
            else if(root.val<p.val){
                return inorderSuccessor(root.right,p);
            }
            else{
                //If p.val<root.val, root maybe the inorder successor
                TreeNode left = inorderSuccessor(root.left,p);
                return left==null?root:left;
            }
        }
    }
}
