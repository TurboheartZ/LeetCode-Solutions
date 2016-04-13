import java.util.*;
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null){
            return root;
        }
        else{
            Stack<TreeNode> DFS = new Stack<TreeNode>();
            while(root!=null){
                DFS.push(root);
                root = root.left;
            }
            TreeNode r = DFS.pop();
            TreeNode result = r;
            while(DFS.isEmpty()==false){
                TreeNode p = DFS.pop();
                r.right = p;
                if(p.right!=null){
                    r.left = p.right;
                }
                else{
                    r.left = null;
                }
                r = r.right;
            }
            //This step is vital, since we need to cut the tails down since the tail node has its previous children
            r.left = null;
            r.right = null;
            return result;
        }
    }
}
