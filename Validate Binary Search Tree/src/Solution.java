
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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        else{
            if((root.left!=null&&root.left.val>=root.val)||(root.right!=null&&root.right.val<=root.val)){
                return false;
            }
            return isValid(root.left,root,(long)Integer.MIN_VALUE-1,root.val)&isValid(root.right,root,root.val,(long)Integer.MAX_VALUE+1);
        }
    }
    //Use min and max to indicate the range of next child's value
    private boolean isValid(TreeNode root, TreeNode grandParent, long min, long max){
        if(root==null){
            return true;
        }
        else{
            boolean result = true;
            if(root.left!=null){
                if(root.left.val<root.val&&(root.left.val>min&&root.left.val<max)){
                    result = result&isValid(root.left,root,min,(long)root.val);
                }
                else{
                    return false;
                }
            }
            if(root.right!=null){
                if(root.right.val>root.val&&(root.right.val>min&&root.right.val<max)){
                    result = result&isValid(root.right,root,(long)root.val,max);
                }
                else{
                    return false;
                }                
            }
            return result;
        }
    }
}
