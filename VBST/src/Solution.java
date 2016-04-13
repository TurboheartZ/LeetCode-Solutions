
public class Solution {
//	public static TreeNode prev = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		TreeNode t1 = s.new TreeNode(1);
		TreeNode t2 = s.new TreeNode(1);
		t1.left = t2;
		t1.right = null;
		t2.left = null;
		t2.right = null;
		
		System.out.println(isValid(t1));
	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x){
			val = x;
		}
	}
	public static boolean isValid(TreeNode root){
		TreeNode prev = null;
		return helper(root, prev);
	}
	
	public static boolean helper(TreeNode node, TreeNode prev){
		if (node == null){
			return true;
		}
		
		if (!helper(node.left, prev)){
			return false;
		}
		
		if (prev != null && prev.val >= node.val){
			return false;
		}
		
		prev = node;
		return helper(node.right, prev);
	}
}
