
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        else{
            return helper(nums,0,nums.length-1);
        }
    }
    
    private TreeNode helper(int[] nums, int begin, int end){
        if(begin>end){
            return null;
        }
        int mid = (begin+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, begin, mid-1);
        root.right = helper(nums, mid+1,end);
        return root;
    }
}
