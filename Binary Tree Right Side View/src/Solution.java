import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    //BFS search
    private static List<Integer> result = new ArrayList<Integer>();
    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return result;
        }
        else{
            Queue<TreeNode> nodes = new LinkedList<TreeNode>();
            nodes.offer(root);
            findNode(nodes);
            return result;
        }
    }
    private static void findNode(Queue<TreeNode> nodes){
        int size = nodes.size();
        if(size==0){
            return;
        }
        TreeNode n = new TreeNode(-1);
        for(int i = 0; i<size; i++){
            n = nodes.poll();
            if(n.left!=null){
                nodes.offer(n.left);
            }
            if(n.right!=null){
                nodes.offer(n.right);
            }
        }
        result.add(n.val);
        findNode(nodes);
    }
}
