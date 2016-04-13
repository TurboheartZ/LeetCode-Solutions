
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
    //This is not easily DFS, since there may be gaps, we cannot just return 1+findPath(...)
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            findPath(root,0,root.val);
            return max;
        }
    }
    private void findPath(TreeNode root, int cur, int target){
        if(root==null){
            return;
        }
        else{
            if(root.val==target){
                cur++;
                max = Math.max(max,cur);
            }
            else{
                cur = 1;
            }
            findPath(root.left,cur,root.val+1);
            findPath(root.right,cur,root.val+1);
        }
    }
}
