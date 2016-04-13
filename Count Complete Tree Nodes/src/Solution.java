
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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        TreeNode n = root;
        int count = 0;
        int l = 0, r = 0;
        while(n!=null){
            //if left depth equals to right depth, means this left child is a full complete tree
            //Then we know that the incomplete tree is inside the right child tree
            //Else if left depth is larger than right depth, we know that this left child subtree is incomplete 
            int[] res = DFS(n.left);
            if(res[1]==0){
                count += power(res[0])+1;
                n = n.right;
            }
            else{
                count += power(res[0])+1;
                n = n.left;
            }
        }
        return count;
    }
    
    private int[] DFS(TreeNode root){
        int[] result = {0,0};
        TreeNode l = root;
        TreeNode r = root;
        while(r!=null){
            l = l.left;
            r = r.right;
            result[0]++;
        }
        result[1] = l==null?0:1;
        return result;
    }
    
    private int power(int n){
        if(n<0){
            return 0;
        }
        return (1<<n)-1;
    }
}
