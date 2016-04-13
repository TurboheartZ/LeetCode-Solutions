
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public class TreeNode {
		  int val;
		  TreeNode left;
		  TreeNode right;
		  TreeNode(int x) { val = x; }
	}
	
    public int rob(TreeNode root) {
        int[] result = DFS(root);
        return Math.max(result[0],result[1]);
    }
    
    public int[] DFS(TreeNode root){
        //result[0] means not select this node, result[1] means selecting this node;
        int[] result = new int[2];
        if(root==null){
            return result;
        }
        else{
            int[] left = DFS(root.left);
            int[] right = DFS(root.right);
            result[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
            result[1] = left[0] + right[0] + root.val;
            return result;
        }
    }
}
