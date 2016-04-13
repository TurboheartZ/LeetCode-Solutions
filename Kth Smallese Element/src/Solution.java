
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
    private int counter = 0;
    private int kth = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return Integer.MIN_VALUE;
            //Means invalid input
        }
        else{
            findKth(root,k);
            return kth;
        }
    }
    private void findKth(TreeNode root, int k){
        if(root==null||counter==k){
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        while(node!=null){
            nodes.push(node);
            node =node.left;
        }
        while(counter!=k&&nodes.isEmpty()==false){
            TreeNode n = nodes.pop();
            counter++;
            if(counter==k){
                kth = n.val;
                return;
            }
            findKth(n.right,k);
        }
        return;
    }
}
